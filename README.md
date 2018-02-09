### Trello - Selenium Automation
---
#### System Requirement:

* JDK 1.7 or above

* Maven 3.1 or above

* Eclipse IDE or any other of choice in case there is need to update the script.

* For execution of scripts on Chrome, you need to have executable file for Chrome driver and paste them at location "\src\test\resources\drivers" in project folder.

* You can download this executable file from below links
  * Chrome: https://drive.google.com/file/d/0B4FqnK04LJRnNWZFOEE3Wjd4aFk/view



#### Pre-Requisites:

* Update credentials for Trello application in the test data file under
    \src\test\resources\testdata\TestData.properties
    
* We must have existing trello card "Learn_Selenium_Tool" under trello list "Learn_Automation" in existing board "SMARTASSISTANT_TASK" in our trello account before running the tests.  
    
 

#### Execution Steps:
Please follow the instructions to execute the tests on local:

Checkout the code from GIT Stash with provided link :
   https://github.com/sarvesh4you/trelloAssignment.git


According to the Test Scope use following commands
  - To Execute the single test suite
	``` mvn clean verify -Dtest="Test suite name"```
	
	 - To Execute the all test suite
	``` mvn clean verify"```

Or use batch files to execute desired suit which are avilable in project base directory.


Or import project in Eclipse as a maven project and run desired suit as maven or as Testng.
   - Location of testng.xml : \src\test\resources\testngxml\Trello_Tests.xml


    
#### Result Files:	
The Test Execution Results will be stored in the following directory once the test has completed

    ./target/test-output/emailable-report.html (for complete test suite)
    ./target/surefire-reports/emailable-report.html (for single test suite)
