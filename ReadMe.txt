*Prerequisites:*

Install Java and Maven https://www.mkyong.com/maven/how-to-install-maven-in-windows/

*To run in command prompt:*
    Go to the Project path [for example- E:\MotorqAutomation]
    Enter following command
        $ mvn clean install
    It will run the test and you can see the result and Check the E:\MotorqAutomation\src\test\resources\Output for any failed cases

*To setup in IntelliJ:*
    Make sure you have Java version 7 (JDK) or above installed in your machine.
    Download IDE IntelliJ [https://www.jetbrains.com/idea/download/] and Install by Choosing Java
    Once IntelliJ is installed, Click File -> New -> Project from Existing Sources
    Select the Project Path, Choose Maven and click Next and Finish the setup

To Run a specific test, Go to that test and Right click that test and Select Run

*Project Structure:*
-src
  -main
    -java
      -motorq (has Base Class , i.e Code to get/post request)
        -contants (has GeotabContants Class, MotorqConstants Class)
        -jsonParserUtil (has jsonParserHelper Class)
        -ResponseClasses (has Motorq and Geotab response POJO classes which helps in serialization of Json to Java Object)
  -test
    -java
      -apiAutomation (has StatusCoreTest which has test cases)
    -resources
      -Output (Any failed scenario will have details in text file)
TestData.properties file is like a config file, will have few variables like timestamp and deviceID.

*Help:*
	To create POJO classes, Go to  http://www.jsonschema2pojo.org/
	Enter a sample Json and Have the annotation style as Jackson 2.x, Click Preview.
	Copy the Classes and paste below the respective packages. Refer jsonParserHelper class for parsing.

