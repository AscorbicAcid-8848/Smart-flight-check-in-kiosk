# Readme
## Important : 
- Make sure your jdk version >= 11. You can check it by typing "java -version" on command line. 
If not, you can download newer jdk and configure it path with:https://www.liquidweb.com/kb/how-to-install-java-on-ubuntu-windows-and-macos/
- Recommend environment: Windows 10. If your OS is linux or mac, you can try to run the program with method 2 or 3
## Start program
PS: You can use the account with username "Jerry" and password "123456" to login in. You can also sign up a new account.
### 1. Run with javac compile (__Recommend, Windows only__, no need for network to download jars)
- Open a terminal and switch in the project folder.
- type command "startup.bat" then press enter to start the program.

if you want to use or test the file storage, when you close the program and the terminal ask you if you want to copy the files, you need to type "A" to the command line 

### 2. Run with maven 3 
- Ensure you have a maven with version 3.x.x . You can check it by typing "mvn -version" on command line.
If you do not have maven, you can try to install with:https://www.baeldung.com/install-maven-on-windows-linux-mac
- Open a terminal and use cd command to switch in the project folder.
- type command "mvn clean javafx:run" then press enter to start the program. (hint: it may take few seconds to start the program as it will download jars from maven repository)

### 3. Run with idea
- Open the idea from the terminal by type "idea" and press enter.
- Click File-Open and choose the project folder.
- Click Run-Run 'Launcher' to start the program (hint: if you can't find the Run 'Launcher', please click the "project" button and find Launcher at "se/src/main/java/main". open the Launcher class and click the green triangle to start the program)
## Test Files
Test files are located at src/test/java
