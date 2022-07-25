# Compile classes in Jar to Dex format

echo "Compile classes in Jar to Dex format"
echo "jar2dex"
sh lib/dex2jar/d2j-jar2dex.sh -f -o tmp/classes.dex tmp/monitored_app-converter.apk.jar
cp app-converter.apk tmp/app-converter.apk
cd tmp