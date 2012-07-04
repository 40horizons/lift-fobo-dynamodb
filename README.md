lift-fobo-dynamodb
==================
 
Prepare the environment
-----------------------

1) Install [Java SE Development Kit 6](http://www.oracle.com/technetwork/java/javase/downloads/jdk6-downloads-1637591.html)

2) Unpack [Eclipse Indigo SR2 IDE for Java EE Developers](http://www.eclipse.org/downloads/packages/release/indigo/sr2)

2) Change eclipse.ini to have

    -Xms512m
    -Xmx1280m

3) Launch Eclipse IDE and provide path to workspace

4) Install and setup [AWS Toolkit for Eclipse](http://aws.amazon.com/articles/3586)

In Eclipse go "Help->Install New Software...", click "Add...", put name "AWS Toolkit for Eclipse" and Location "http://aws.amazon.com/eclipse/", wait for list of apps to load, check "AWS Toolkit for Eclipse", click "Next", click "Next", accept license, click "Finish", wait for installation to complete (click "Ok" to install unsigned software), click "Restart Now"

In browser sign up to [Amazon Web Services](http://aws.amazon.com/) and get your "Access Key ID" and "Secret Access Key" from [Security Credentials](https://portal.aws.amazon.com/gp/aws/securityCredentials#access_credentials) page or use [AWS Identity and Access Management](https://console.aws.amazon.com/iam/home?#s=Users) to create users with specific rights for access

In Eclipse go "Window->Preferences", type "aws" and click "AWS Toolkit". Click "Add account", input "Account Name", "Access Key ID" and "Secret Access Key", click "Apply". Add more accounts if needed and remove default account. Click "Ok".
In Eclipse go "File->New->Project...", type "aws", choose "AWS Java Project", click "Next", wait for "AWS SDK for Java" to complete downloading. Click "Cancel".

5) Install and setup [EGit for Eclipse](http://eclipse.github.com/#help)

In Eclipse go "Help->Install New Software...", click "Add...", put name "Juno" and Location "http://download.eclipse.org/releases/juno", type in filter "egit" and press enter, wait for list of apps to load, check "Eclipse EGit", click "Next", click "Next", Accept license, click "Finish", wait for installation to complete, click "Restart Now"

In Eclipse go "Window->Preferences", type "git" and click "Team->Git->Configuration". Click "Add entry...", input user.name="your_name_on_github" and user.email="your_email_for_github".
In Eclipse go "Window->Preferences", type "ssh2" and click "General->Network Connections->SSH2". Add exiting key or generate new one. Add public key to your git account, look [here](https://help.github.com/articles/generating-ssh-keys) (ssh-keygen -t rsa -C "your_email_for_github")

6) Install [Scala IDE for Eclipse](http://scala-ide.org/download/current.html)

In Eclipse go "Help->Install New Software...", click "Add...", put name "Scala IDE for Scala 2.9" and Location "http://download.scala-ide.org/releases-29/stable/site", wait for list of apps to load, check "Scala IDE for Eclipse", click "Next", click "Next", accept license, click "Finish", wait for installation to complete, click "Restart Now"

7) ? Download and install [Git for Windows](http://msysgit.github.com/) or install git via your linux updater

8) ? Download and install [Scala 2.9.2](http://www.scala-lang.org/downloads)

Get the app working
-------------------

1) Install [Fobo Module](https://github.com/karma4u101/FoBo)

Open the link and click ZIP button on a page and unzip downloaded file
If untyped.com is blocked by your corporate fire wall then in "FoBo/project/plugins.sbt" add after:
    
    resolvers += "Untyped" at "http://repo.untyped.com"
    
this (separate strings by empty lines):
    
    resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
    
Then run sbt-publish-local.bat

After that in your home directory in .ivy2\local will appear net.liftmodules with fobo (see last info message)

2) Get [app](https://github.com/40horizons/lift-fobo-dynamodb) and update it

Note: if you will see "Run Scala Setup Diagnistic" then click "Ok", select "Use recommended default settings", click "Ok"

In Eclipse go "Window->Open perspective->Other...", choose "Scala", click "Ok"

Following [this tutorial](http://www.vogella.com/articles/EGit/article.html#clone_respository) import project using URI https://github.com/40horizons/lift-fobo-dynamodb.git and branch "master". Before "Import existing projects" launch sbt.bat from the app folder and type

    > eclipse

Then in Eclipse click "Next" and "Finish"

3.1) To just see app in browser start [Jetty](http://jetty.codehaus.org/jetty/)

Run sbt.bat

    > container:start

3.2) To edit app and see changes start [Jetty](http://jetty.codehaus.org/jetty/) this way

Run sbt.bat

    > ~;container:start; container:reload /

3.3) To stop [Jetty](http://jetty.codehaus.org/jetty/) and exit

    > container:stop
    > exit

4) Launch your browser and see app [running](http://localhost:8080/)
	
    http://localhost:8080/

5) Add AWS SDK to the project

In Eclipse go "Project->Properties", type "lib", choose "Java Build Path", click on "Library" tab, click "Add Library...", choose "AWS SDK for Java", click "Finish"

6) Edit project and reload browser

7) After each small goal is reached commit the change

In Eclipse right click on project root, go "Team->Commit..."

8) After big goal is reached commit the last change and push all changes to github

In Eclipse right click on project root, go "Team->Remote->Push..."
