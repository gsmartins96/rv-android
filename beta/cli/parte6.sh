# Instrument application with monitor classes

echo "# Instrument application with monitor classes"

ajc -cp lib/android-30/android.jar:lib/android-30/android-30-api.jar:lib/aspectjrt.jar:lib/rvmonitorrt.jar -inpath tmp -showWeaveInfo -d tmp -source 1.9 -sourceroots aspects
if [ "$?" = 1 ] ; then
    echo "AspectJ has encountered a fatal error and needs to close. Dying!"
    exit
fi