#!/bin/bash -e

#title           :backup_dropbox.sh
#description     :Bash script backup Dropbox folder to timestamp zip file
#author	         :George
#date            :20220217
#version         :1.0.0
#usage           :bash backup_dropbox.sh
#bash_version    :5.0.17(1)-release
#====================================================================================================================

readonly time_stamp=$(date +"%Y%m%d %T")
readonly zip_file_name=Dropbox_$(date +"%Y%m%d").zip

echo "Start backup"
rm -rf ${zip_file_name}
zip ${zip_file_name} -r  ~/Dropbox
echo "Finished backup"
