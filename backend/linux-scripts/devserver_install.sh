#!/bin/bash -e

#title           :devserver_install.sh
#description     :Bash script to download and install user defined tools from Ubuntu repositories (apt and snap)
#author	         :George
#date            :20230702
#version         :1.0.0
#usage           :bash devserver_install.sh
#bash_version    :5.0.17(1)-release
#====================================================================================================================

echo "DevServer install version 1.0.0"

echo "---------------------------------------------------------"
echo " Start install applications from package managers"
echo "---------------------------------------------------------"

# Prepare
sudo apt update
sudo apt upgrade

# Console tools
sudo apt install -y mc
sudo apt install -y vim
sudo apt install -y git
sudo snap install htop
sudo apt install -y sox
sudo apt install -y ffmpeg
sudo snap install yt-dlp
sudo snap install curl
sudo apt install -y lm-sensors
sudo apt install -y translate-shell
sudo apt install -y tree
sudo apt install -y jq
sudo apt install -y sshfs

# Other tools
sudo snap install chromium


# Programming tools
sudo snap install openjdk
sudo apt install maven -y

sudo apt install software-properties-common -y
sudo add-apt-repository ppa:deadsnakes/ppa
sudo apt install python3.11 -y
sudo apt install python3-pip -y 
sudo apt install python3.11-venv -y

sudo apt install mysql-server -y

sudo snap install code --classic
sudo snap install postman
sudo snap install dbeaver-ce

sudo snap install pycharm-community --classic
sudo snap install intellij-idea-community --classic

# Create folders structure
mkdir ~/SourceCode
mkdir ~/app
mkdir ~/log

echo "---------------------------------------------------------"
echo " Finish install applications from package managers"
echo "---------------------------------------------------------"
