# Parte 1

# Set up output directories, removing old files
echo "Diretorios e remoção de arquivos antigos"
rm -rf out tmp rvm_tmp
mkdir out
mkdir tmp
mkdir rvm_tmp

# Convert APK to Jar (with Java bytecode), verify output Jar
echo "[+] Extracting Java classes to JAR in tmp/"
sh lib/dex2jar/d2j-dex2jar.sh -f -o tmp/no_monitor_app-converter.apk.jar app-converter.apk
sh lib/dex2jar/d2j-asm-verify.sh tmp/no_monitor_app-converter.apk.jar

# Extract application classes, remove temporary application Jar
echo "Extraindo classes e remove o jar gerado"

cd tmp
jar xf no_monitor_app-converter.apk.jar
cd ..