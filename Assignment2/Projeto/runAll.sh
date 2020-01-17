#!/bin/bash

bash cleanRemoteFiles.sh;
bash killProcesses.sh;
bash scriptDeployment.sh &&

sleep 1m;

bash getLog.sh;

