# Extract RV-Monitor support classes

echo "Extract RV-Monitor support classes"
cp lib/rvmonitorrt.jar rvm_tmp/.
cd rvm_tmp
jar xf rvmonitorrt.jar

echo "Remove rvmonitorrt's manifest and the temporarily copied Jar + property files"
rm -rf META-INF rvmonitorrt.jar
cd ..

echo "# Merge RV-Monitor support classes"

cp -r rvm_tmp/ tmp/
rm -rf rvm_tmp/*

echo "Compress resulting transformed classes to Jar"
cd tmp
jar cf monitored_app-converter.apk.jar *
cd ..

