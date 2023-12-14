#!/bin/bash -e

#title           :desktop_install.sh
#description     :Bash script to download and install user defined tools from Ubuntu repositories (apt and snap)
#author	         :Lucy
#date            :20230702
#version         :1.0.1
#usage           :bash desktop_install.sh
#bash_version    :5.0.17(1)-release
#====================================================================================================================

echo "Desktop install version 1.0.1"

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
sudo snap install vlc
sudo snap install spotify
sudo snap install p7zip-desktop
sudo snap install discord
sudo snap install telegram-desktop
sudo apt install -y virtualbox
sudo apt install -y simplescreenrecorder
sudo snap install chromium

# Market analyst tools
sudo snap install tradingview

# Programming tools
sudo snap install code --classic

# Manual install
wget "https://github.com/mucommander/mucommander/releases/download/1.2.0-1/mucommander_1.2.0-1_amd64.deb"
wget "https://www.dropbox.com/download?dl=packages/ubuntu/dropbox_2020.03.04_amd64.deb"

echo "---------------------------------------------------------"
echo " Finish install applications from package managers"
echo "---------------------------------------------------------"
