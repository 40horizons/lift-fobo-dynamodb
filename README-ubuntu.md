lift-fobo-dynamodb
==================
 
Points for start
----------------

1) Install and update [Ubuntu Server 12.04 LTS 64 bit](http://www.ubuntu.com/download/server) in [VMware Player 4.0.4](https://my.vmware.com/web/vmware/evalcenter?p=player) selecting OpenSSH server to be installed also on one of last pages

    sudo apt-get update
    sudo apt-get upgrade

2) Install VMware Tools to use shared folder for command line utilities from linux and for eclipse ide from windows.

    sudo apt-get install build-essential
    sudo mount /dev/cdrom /media/cdrom
    cp /media/cdrom/VMwareTools-8.8.4-743747.tar.gz ~
    tar zxf VMwareTools-8.8.4-743747.tar.gz
    cd ~/vmware-tools-distrib
    ./vmware-install.pl

3) If you are behind a proxy which allows connections to 443

sudo vim /ect/hosts

    192.168.xxx.yyy  sandbox
    192.168.xxx.1    base

sudo vim /etc/environment

    http_proxy=http://base:3128/
    https_proxy=http://base:3128/
    ftp_proxy=http://base:3128/
    HTTP_PROXY=http://base:3128/
    HTTPS_PROXY=http://base:3128/
    FTP_PROXY=http://base:3128/
    no_proxy="base,localhost,127.0.0.1,localaddress,.localdomain.com"
    NO_PROXY="base,localhost,127.0.0.1,localaddress,.localdomain.com"

sudo apt-get install [corkscrew](http://www.agroman.net/corkscrew/)

vim ~/.ssh/config

    host github.com
        user git
        hostname ssh.github.com
        port 443
        proxycommand corkscrew base 3128 %h %p

4) Install JDK

    sudo apt-get install openjdk-6-jdk

5) Install and configure git
    
    sudo apt-get install git
    git config --global --add http.proxy $http_proxy
    git config --global --add user.name sandbox
    git config --global --add user.email sandbox@xxxx.com

6) Gen keys and add contents of id_rsa.pub on your admin page see Step 4 [here](https://help.github.com/articles/generating-ssh-keys)

    ssh-keygen -t rsa -C "sandbox@xxxx.com"
    cat ~/.ssh/id_rsa.pub

7) Test ssh connection

    ssh -v git@github.com
    
You should see "Hi sandbox!..." if not then check output for errors

8) Compile [FoBo Module](https://github.com/karma4u101/FoBo)

This step involves a one liner command for local publish of the FoBo module.  

9) Get the app

	git clone git://github.com/40horizons/lift-fobo-dynamodb.git
	cd lift-fobo-dynamodb

10) Update

	./sbt update

11) Run Jetty

    $ ./sbt
    > ~;container:start; container:reload /

12) Launch Your Browser
	
	http://SandboxVar:8080/

13) Install [Scala IDE](http://scala-ide.org/download/current.html) for Eclipse 2.0.1 Release

14) Generate project

	./sbt
	> eclipse 

15) Open project in eclipse 

	File ==> Import...
	Select General ==> Existing Project into Workspace 
	Use "Brows" to look up the project root ....
