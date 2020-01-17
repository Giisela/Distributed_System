# Remover tudo dos servidores

bold=$(tput bold)
normal=$(tput sgr0)

echo "${bold}*** Script de Remoção ***${normal}"

export SSHPASS='enterro2019'

echo -e "\n${bold}* Remoção dos Projetos em cada nó *${normal}"

echo -e "\n${bold}->${normal} A remover General Information Repository na máquina ${bold}1${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws01.ua.pt << EOF
	rm -rf GeneralInformationRepo/  
    rm -f print.txt 
    exit
EOF

echo -e "\n${bold}->${normal} A remover Lounge na máquina ${bold}2${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws02.ua.pt << EOF
	rm -rf Lounge/
    rm -f print.txt
	exit
EOF

echo -e "\n${bold}->${normal} A remover OutsideWorld na máquina ${bold}3${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws03.ua.pt << EOF
	rm -rf OutsideWorld/
    rm -f print.txt
    exit
EOF

echo -e "\n${bold}->${normal} A remover SupplierSite na máquina ${bold}4${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws04.ua.pt << EOF
	rm -rf SupplierSite/
    rm -f print.txt
	exit
EOF

echo -e "\n${bold}->${normal} A remover RepairArea na máquina ${bold}5${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws05.ua.pt << EOF
	rm -rf RepairArea/
    rm -f print.txt
	exit
EOF

echo -e "\n${bold}->${normal} A remover Park na máquina ${bold}6${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws06.ua.pt << EOF
	rm -rf Park/
    rm -f print.txt
	exit 
EOF

echo -e "\n${bold}->${normal} A remover Manager na máquina ${bold}7${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws07.ua.pt << EOF
	rm -rf Manager/
    rm -f print.txt
	exit
EOF

echo -e "\n${bold}->${normal} A remover Mechanics na máquina ${bold}8${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws08.ua.pt << EOF
	rm -rf Mechanics/
    rm -f print.txt
    exit
EOF

echo -e "\n${bold}->${normal} A remover Customer na máquina ${bold}9${normal}"
sshpass -e ssh -t -t -o StrictHostKeyChecking=no sd0401@l040101-ws09.ua.pt << EOF
	rm -rf Customer/
    rm -f print.txt
    exit
EOF