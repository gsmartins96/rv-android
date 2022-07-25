# Replace old classes.dex in APK with new classes.dex

echo "Replace old classes.dex in APK with new classes.dex"
echo "[+] Replace with new classes.dex"
zip -r app-converter.apk . -i tmp/classes.dex