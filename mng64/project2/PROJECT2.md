# Programming project 2: JUnit Testing
* Due date: Sunday April 12 11:59 p.m.

**Goal:** The goal of the project is to help students understand the use of JUnit to test Java code.  You will create a set of unit tests, to test the behavior of the code written for project 1.  To keep things consistent, use the solution to project 1 provided by the instructor in src.git -> project2 folder

**Unit testing** is used to test the behavior of the code (or parts of the code) written, without having to run the whole program. Assume that the front-end (MovieReviewApp console user interface) part of the program and the back-end part of the program (ReviewHandler) are written by two different developers.  Unit testing ensures that the back-end code works correctly without having access to the front-end. 

In this project, you will create JUnit tests to test the class ReviewHandler written for project 1 and all its methods (including the ones inherited from AbstractReviewHandler). You do not need to test the other classes (i.e. MoviewReviewApp, MoviewReview).  
Start with testing the behavior of the class/methods under normal operation scenarios.  Create a ReviewHandlerTest class to test all behaviors of methods in ReviewHandler class. For example, to test the method 
```
public List<MovieReview> searchBySubstring(String substring)
```
of the class ReviewHandler, you may need to create a test method testSearchBySubstring, which creates a few mock MovieReview objects and adds them to the database before the method searchBySubstring can be called to search for the substring. To ensure that everything worked as planned, you can then compare the results that were returned with the expected results. Mock objects can be created either in the same test method or before any test methods are run, using the @BeforeAll or @BeforeEach annotation. 

**Do NOT modify the code of the solution to project 1 provided.**

## Tasks:

1.	Implement the JUnit tests to test only the class ReviewHandler.java. Try to be creative by coming up with test cases that can test as many different situations as possible. You don’t need to test the other classes.

2.	Use a standard Java coding style to improve your program’s visual appearance and make it more readable e.g. https://google.github.io/styleguide/javaguide.html

3.	Use Javadoc to document your code.


## Logistics:
* The code of the solution for Project 1 should also be cloned from https://git.txstate.edu/CS3354/src.git, project2 folder. 

* **Submit** content of **test/project2** folder to https://git.txstate.edu/CS3354/NetID.git. 

* **Submit** content of **data** folder to https://git.txstate.edu/CS3354/NetID.git. Only add items you are testing in **data** folder, **there is no need to add 500 items. 

* This project can be done in teams and will be submitted individually by each student.

##Compilation 

Compile and run JUnit5 testing. Download junit-platform-console-standalone-1.6.1.jar from https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.6.1/ and place it in lib folder at the same level with src, test, Net_ID, and material folders. 

```
javac -d classes -cp .\classes;.\lib\junit-platform-console-standalone-1.6.1.jar .\src\project2\*.java .\<Net_ID>\project2\*.java

java -cp ".\lib\junit-platform-console-standalone-1.6.1.jar";".\classes" org.junit.platform.console.ConsoleLauncher --exclude-engine=junit-vintage --include-engine=junit-jupiter --fail-if-no-tests --scan-classpath
```
