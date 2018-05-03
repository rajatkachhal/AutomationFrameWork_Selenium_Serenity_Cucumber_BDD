# Framework with Selenium, Cucumber and Serenity BDD
This contains few automation examples on a website using Selenium, Cucumber and Serenity BDD

## Prerequisites : -
•	Should have java installed

•	Should have maven installed

## Execute Test : -
The Default Browser used is Chrome

•	mvn clean test

If User Wants to specify the browser than he must use

•	For Chrome

    mvn clean verify -P chrome

•	For Firefox

    mvn clean verify -P firefox

•	For Headless

    mvn clean verify -P phantomjs

## Please Note : -

Since the drivers used for windows and mac are different If the user wishes to run the test pack on mac than he has to make the following changes

•	Traverse to pom.xml and remove .exe from all the following : -

     • src/test/resources/driver/geckodriver.exe

     • src/test/resources/driver/chromedriver.exe

     • src/test/resources/driver/phantomjs.exe

## Execution Results : -

An html file is generated at the location : - "target/site/serenity/index.html"

The Report will be in the below format : -

<img width="1036" alt="screen shot 2017-12-08 at 8 21 39 pm" src="https://user-images.githubusercontent.com/14148321/33774346-66a64070-dc54-11e7-9e68-292f6eceac2a.png">





