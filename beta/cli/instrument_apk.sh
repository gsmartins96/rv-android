#!/bin/sh

# Copyright 2014 Runtime Verification Inc., All Rights Reserved

CLASSPATH=/Users/gabrielmartins/Android/Sdk/platforms/android-26/android.jar:lib_tmp/aspectjrt.jar:lib_tmp/aspectjtools.jar:lib_tmp/aspectjweaver.jar:lib_tmp/cfg.jar:lib_tmp/ere.jar:lib_tmp/fsm.jar:lib_tmp/guava.jar:lib_tmp/logicrepository.jar:lib_tmp/ltl.jar:lib_tmp/pda.jar:lib_tmp/po.jar:lib_tmp/ptcaret.jar:lib_tmp/ptltl.jar:lib_tmp/rv-monitor-rt.jar:lib_tmp/rv-monitor.jar:lib_tmp/rvsec.jar:lib_tmp/scala-library.jar:lib_tmp/scala-parser-combinators_2.11.jar:lib_tmp/srs.jar:lib_tmp/surefire-api.jar:lib_tmp/surefire-booter.jar:lib_tmp/surefire-extensions-spi.jar:lib_tmp/surefire-logger-api.jar:lib_tmp/surefire-shared-utils.jar:lib_tmp/tfsm.jar:.
JAVAMOP_HOME=lib/javamop/
RV_MONITOR_HOME=../../../rv-monitor

if [ "$#" -ne 5 ]; then
    echo "Illegal number of parameters!"
    echo "Usage: instrument_apk.sh [apk] [keystore] [keystore password] [signing key alias] [monitors_directory]"
    exit
fi

# Set up output directories, removing old files
echo "[+] Remove generated files"
find $5 -name "*Monitor.java" -exec rm -Rf {} \;
rm -rf out tmp 
rm -rf
rm -rf monitors/*.aj monitors/*.rvm
mkdir out
mkdir tmp
mkdir rvm_tmp

# Convert APK to Jar (with Java bytecode), verify output Jar
echo "[+] Extracting Java classes to JAR in tmp/"
sh lib/dex2jar/d2j-dex2jar.sh -f -o tmp/no_monitor_$1.jar $1

echo "[+] Verify monitor em /tmp"
sh lib/dex2jar/d2j-asm-verify.sh tmp/no_monitor_$1.jar

# Extract application classes, remove temporary application Jar
echo "[+] Extract application classes"
unzip -q tmp/no_monitor_$1.jar -d tmp
rm tmp/no_monitor_$1.jar
# jar xf no_monitor_$1.jar
# cd ..

# --------------- R E M O V E D -------------- #
# Use RV-Monitor to compile all monitors to bytecode
#cd $5
#for i in *.rvm; do
#    out=$(rv-monitor $i)
#    if echo $out | grep -q "generated" ; then
#        echo "RV-Monitor successfully processed $i."
#    else
#        echo "RV-Monitor failed to process $i with an error! Failing!"
#        exit
#    fi
#done
# --------------- R E M O V E D -------------- #

echo "[+] Executing JavaMOP"
$JAVAMOP_HOME/bin/javamop -s -merge $5/*.mop

echo "[+] Executing RV-Monitor"
$RV_MONITOR_HOME/bin/rv-monitor -s -merge -d $5 $5/*.rvm

# Remove sources and dependencies
cp -r rvm_tmp/ tmp/
# cd ..

# --------------- R E M O V E D -------------- #
# Move all Java monitor classes into their final package namespace directory
# python3 lib/fix_java_packages.py
# if [ "$?" = 1 ] ; then
    # Unable to resolve Java package
#    exit
# fi
# --------------- R E M O V E D -------------- #

# Merge monitor and application sources
echo "[+] Merge monitor and application sourcers"
# cp $6/*.aj rvm_tmp/.
cp $5/*.java rvm_tmp/.
cp -rf rvm_tmp/ tmp/
rm -rf rvm_tmp/*

# Instrument application with monitor classes
echo "[+] Executing AspectJ"
ajc -Xmx10240m -cp $CLASSPATH:monitors:tmp:. -Xlint:ignore -showWeaveInfo -inpath tmp -d tmp -source 1.8 -sourceroots $5 
if [ "$?" = 1 ] ; then
    echo "AspectJ has encountered a fatal error and needs to close. Dying!"
    exit
fi

# Extract RV-Monitor support classes
echo "[+] Extract RV-Monitor support classes"
cp lib_tmp/rv-monitor-rt.jar rvm_tmp/.
cd rvm_tmp
jar xf rv-monitor-rt.jar

# Remove rvmonitorrt's manifest and the temporarily copied Jar + property files
rm -rf META-INF rv-monitor-rt.jar
cd ..

# Merge RV-Monitor support classes
cp -r rvm_tmp/ tmp/
rm -rf rvm_tmp/*

# Compress resulting transformed classes to Jar
cd tmp
jar cf monitored_$1.jar *
cd ..

# Compile classes in Jar to Dex format
echo "[+] Compile classes in Jar to Dex format"

# Using jar2dex from Dex2Jar
# sh lib/dex2jar/d2j-jar2dex.sh -f -o tmp/classes.dex tmp/monitored_$1.jar

# Using D8 from SDK Build Tools
sh lib/build-tools/30.0.3/d8 tmp/monitored_$1.jar

# If using D8, change classes.dex folder
echo "Coping classes.dex to /tmp and delete from this directory"
cp classes.dex ./tmp
rm classes.dex

cp $1 tmp/$1
cd tmp

# Replace old classes.dex in APK with new classes.dex
echo "[+] Replace with new classes.dex"
# zip -r $1 . -i classes.dex
zip -r $1 classes.dex

# Copy final classes.dex
cp $1 ../out/unsigned_$1
cd ..

# Verify and sign the Jar with debug key, repairing any inconsistent manifests
sh lib/dex2jar/d2j-asm-verify.sh out/unsigned_$1
cd out

# Sign debug Jar with final key
sh ../lib/dex2jar/d2j-apk-sign.sh -f -o $1 unsigned_$1
zip -d $1 "META-INF*"
echo $3 | jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore $2 $1 $4

# Clean up
cd ..
rm -rf tmp rvm_tmp

echo "[+] Done! Final apk generated in out/$1"
