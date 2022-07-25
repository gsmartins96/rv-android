# Use RV-Monitor to compile all monitors to bytecode
echo "Compilando os monitores da pasta /monitors"

cd monitors
for i in *.rvm; do
    out=$(rv-monitor $i)
    if echo $out | grep -q "generated" ; then
        echo "RV-Monitor successfully processed $i."
    else
        echo "RV-Monitor failed to process $i with an error! Failing!"
        exit
    fi
done