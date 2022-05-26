# Readme
## Important : 
- Make sure your jdk version = 15. You can check it by typing "java -version" on command line. 
If not, you can download newer jdk and configure it path with:https://www.liquidweb.com/kb/how-to-install-java-on-ubuntu-windows-and-macos/
- Recommend environment: Windows 10 or 11.
## Start program
PS: You can check in in three ways.
1.Using booking number"10001","20001","10002","10102"......(You can check what you want at passengerList.json)
2.Using surname "Ye" and passenger id "1" to check in.
3.Scanning your id document, put the passenger's json file, in Passenger_IdCard folder, you want to check in and put the file into idDocumentCard folder.

### 1. Run with maven 3 
- Ensure you have a maven with version 3.x.x . You can check it by typing "mvn -version" on command line.
If you do not have maven, you can try to install with:https://www.baeldung.com/install-maven-on-windows-linux-mac
- Open a terminal and use cd command to switch in the project folder.
- type command "mvn clean javafx:run" then press enter to start the program. (hint: it may take few seconds to start the program as it will download jars from maven repository)

### 2. Run with idea
- Open the idea from the terminal by type "idea" and press enter.
- Click File-Open and choose the project folder.
- Click Run-Run 'Launcher' to start the program (hint: if you can't find the Run 'Launcher', please click the "project" button and find Launcher at "se/src/main/java/main". open the Launcher class and click the green triangle to start the program)
###3. Initialize the backend data
- Please run the test/mocks/MockAllTest before starting the System to refresh the data.
## Test Files
Test files are located at src/test/java
