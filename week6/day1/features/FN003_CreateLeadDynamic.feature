Feature: Lead Creation in Leaftaps Application

  Background:
    # Given I launch the browser
    # And I load the application url
    And I enter the username as 'democsr'
    And I enter the password as 'crmsfa'
    When I click login button
    Then I should be redirected to the home page
    When I click 'CRM/SFA' link
    And I click 'Leads' link
    And I click 'Create Lead' link

  # Dynamic parameterization 
  # Positive scenario
  @BN1123@Regression@Positive
  Scenario Outline: Validating Lead Creation by filling the mandatory fields
    Given I enter Company Name as '<companyName>'
    And I enter First name as '<firstName>'
    And I enter Last name as '<lastName>'
    When I click Create Lead button
    Then I should view The Lead created with the Company

    Examples:
      | companyName | firstName | lastName |
      | Infosys     | Aswathy   | S        |
      | TCS         | Nadasha   | M        |
      | CTS         | Liya      | N        |
   
   
    # Negative Scenario
  @Negative
  Scenario: Validating Lead Creation by without filling the mandatory fields
  Given I enter Phone Number as '33456'
  When I click Create Lead button
  But I should view parameter is missing 
