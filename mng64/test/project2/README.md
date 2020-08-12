## src.git -> project2 folder contains instructor provided solution is a starting point for project2

## How to use git repositories for project2 submission

1. If you have cloned src and test repository, navigate to local code directory where they reside and pull the code 
```
cd src
git pull
cd ..\test
git pull 
```

2. navigate to test/project2 folder

3. navigate to <NET_ID> folder and paste project2 folder in there

 * make changes to java code in **<NET_ID>/project2** folder and save changes using IDE or text editor of choice: VS Code, IntelliJ, Eclipse, Netbeans, Notepad++, Atom
 * make changes to README.md to include the commandline on how to run the test
 * add folder **data** to Net_ID to contain **only** the files you are using for your JUnit testing. 
 * all the links in your code should assume it is run from the top folder, and data path is <Net_ID>/data 
  
5. Compile and run JUnit5 testing. Download junit-platform-console-standalone-1.6.1.jar from https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.6.1/ and place it in lib folder at the same level with src, test, Net_ID, and material folders. 

```
javac -d classes -cp .\classes;.\lib\junit-platform-console-standalone-1.6.1.jar .\src\project2\*.java .\<Net_ID>\project2\*.java

java -cp ".\lib\junit-platform-console-standalone-1.6.1.jar";".\classes" org.junit.platform.console.ConsoleLauncher --exclude-engine=junit-vintage --include-engine=junit-jupiter --fail-if-no-tests --scan-classpath
```

6. Occasionally check in changes to  **<NET_ID>** repository to save work. make sure you are in CS3354/<NET_ID> folder for git command-line:

```
cd <NET_ID>
git add project2/*.java
git add -f test/*
git commit -m "Project 2 JUnit test cases x y z"
gitk
```
gitk will show you the status, close it to continue
```
git push origin:<NET_ID>
```
Make sure to check-in **final** submission. 

## Other Class resources 
* [lectures](canvas.txstate.edu)
* [material](git.txstate.edu/CS3354/material)
