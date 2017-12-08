# PropertyFinder
This contains few automation examples on Property Finder website using Selenium, Cucumber and Serenity

# Prerequisites : -
•	Should have java installed
•	Should have maven installed

# Execute Test : -
The Default Browser used is Chrome

•	mvn clean test

If User Wants to specify the browser than he must use

•	For Chrome

    mvn clean verify -P chrome

•	For Firefox

    mvn clean verify -P firefox

•	For Headless

    mvn clean verify -P phantom.js

# Please Note : -

Since the drivers used for windows and mac are different If the user wishes to run the test pack on mac than he has to make the following changes

•	Traverse to pom.xml and remove .exe from all the following : -

     • src/test/resources/driver/geckodriver.exe

     • src/test/resources/driver/chromedriver.exe

     • src/test/resources/driver/phantomjs.exe

# Execution Results : -

An html file is generated at "target/site/index.html"

The Report will like the below format : -





