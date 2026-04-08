Feature: User Authentication in Leaftaps Application

@Smoke
Scenario: Validating the Leaftaps Application by providing the valid user credentials

Given User launch the browser
Given User load the application url
Given user enter the username as demosalesmanager
Given User enter the password as crmsfa
When User click on the login button
Then User should be redirected to the home page
