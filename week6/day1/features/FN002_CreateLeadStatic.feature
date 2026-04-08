Feature: Lead Creation in Leaftaps Application

  # Static parameterization
  Scenario: Validating Lead Creation by filling the mandatory fields

    # Given I launch the browser
    # And I load the application url
    And I enter the username as 'democsr'
    And I enter the password as 'crmsfa'
    When I click login button
    Then I should be redirected to the home page
    When I click 'CRM/SFA' link
    And I click 'Leads' link
    And I click 'Create Lead' link 
    Given I enter Company Name as 'TCS'
    And I enter First name as 'Nadasha'
    And I enter Last name as 'M'
    When I click Create Lead button
    Then I should view The Lead created with the Company as 'TCS'