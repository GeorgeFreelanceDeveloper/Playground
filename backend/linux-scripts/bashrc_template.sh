# Servers
alias server_test1='ssh test1@192.168.1.199'
alias server_test2='ssh test1@192.168.1.199'
alias server_prod1='cd ~;ssh -i .ssh/TradingServerProd.pem prod1@18.168.139.95'
alias server_prod2='cd ~;ssh -i .ssh/TradingServerProd.pem prod2@18.168.139.95'
alias server_prod1_connect_home_folder='sshfs -o IdentityFile=/home/jirka/.ssh/TradingServerProd.pem  prod1@18.168.139.95:/home/prod1 ~/Remote/prod1'

# Apps
alias backoffice='cd ~/app/trading-backoffice/trading-backoffice-1.0.0; make run'
alias reports_download="scp -i ~/.ssh/TradingServerProd.pem -r prod1@18.168.139.95:/home/prod1/reports/ ~/Dropbox/Share/"
