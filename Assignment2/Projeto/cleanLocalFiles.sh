bold=$(tput bold)
normal=$(tput sgr0)
echo "${bold}*** Clean Local Files ***${normal}"

echo -e "\n${bold}* Limpeza dos ficheiros class em cada nó *${normal}\n"

echo -e "${bold}->${normal} A limpar o Manager"
cd Manager/
find . -name '*.class' -type f -delete
cd ..

echo -e "${bold}->${normal} A limpar o Mechanic"
cd Mechanics/
find . -name '*.class' -type f -delete
cd ..

echo -e "${bold}->${normal} A limpar o Customer"
cd Customer/
find . -name '*.class' -type f -delete
cd ..

echo -e "${bold}->${normal} A limpar o Lounge"
cd Lounge/
find . -name '*.class' -type f -delete
cd ..

echo -e "${bold}->${normal} A limpar o RepairArea"
cd RepairArea/
find . -name '*.class' -type f -delete
cd ..

echo -e "${bold}->${normal} A limpar o OutsideWorld"
cd OutsideWorld/
find . -name '*.class' -type f -delete
cd ..

echo -e "${bold}->${normal} A limpar o Park"
cd Park/
find . -name '*.class' -type f -delete
cd ..

echo -e "${bold}->${normal} A limpar o SupplierSite"
cd SupplierSite/
find . -name '*.class' -delete
cd ..


echo -e "${bold}->${normal} A limpar o General Information Repository"
cd GeneralInformationRepo/
find . -name '*.class' -delete
find . -name 'log.txt' -delete
cd ..
echo -e "\n${bold}->${normal} A limpeza terminou"
