# PropertyFinder
This contains few automation examples on Property Finder website using Selenium, Cucumber and Serenity

# Prerequisites
•	Have java installed
•	Have maven installed

# Execute Test
The Default Browser used is Chrome
mvn clean test

If User Wants to specify the browser than he must use
•	For Chrome
mvn clean verify -P chrome

•	For Firefox
mvn clean verify -P firefox

•	For Headless
mvn clean verify -P phantom.js
