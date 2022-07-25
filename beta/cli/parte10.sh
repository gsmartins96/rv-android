# Copy final classes.dex

echo "Copy final classes.dex"
cp app-converter.apk ../out/unsigned_app-converter.apk
cd ..

echo "Verify and sign the Jar with debug key, repairing any inconsistent manifests"
sh lib/dex2jar/d2j-asm-verify.sh out/unsigned_app-converter.apk
cd out

echo "Sign debug Jar with final key"
sh ../lib/dex2jar/d2j-apk-sign.sh -f -o app-converter.apk unsigned_app-converter.apk
zip -d app-converter.apk "META-INF*"
echo android | jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore /Users/gabrielmartins/.android/debug.keystore app-converter.apk androiddebugkey

echo "Clean up"
cd ..
rm -rf tmp rvm_tmp
echo "[+] Done! Final apk generated in out/app-converter.apk"