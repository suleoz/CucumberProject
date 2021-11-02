Feature: Search employee

  @regression @sprint4
  Scenario: Search employee by id
#    Given user is navigated to HRMS
    And user is logged in with valid admin credentials
    And user navigates to employee list page
    When user enters valid employee id
    And click on search button
    Then user see employee information is displayed

@regression @sprint4
  Scenario: Search employee by name
#    Given user is navigated to HRMS
    And user is logged in with valid admin credentials
    And user navigates to employee list page
    When user enters valid employee name
    And click on search button
    Then user see employee information is displayed




