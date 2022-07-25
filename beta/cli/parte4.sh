# Move all Java monitor classes into their final package namespace directory

echo "Movendo as classes do monitores"
python3 lib/fix_java_packages.py
if [ "$?" = 1 ] ; then
    # Unable to resolve Java package
    exit
fi
rm tmp/no_monitor_app-converter.apk.jar