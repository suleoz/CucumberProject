Feature: Add Employee

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add Employee button

  @today
  Scenario: first scenario of adding the employee

    And user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully

  @today11
  Scenario: adding the employee from feature file

    And user enters "Sule12" "Gg" and "ozzy"
    And user clicks on save button
    Then employee added successfully

  @today
    Scenario: second scenario of adding the employee

      And user enters firstname middlename and lastname
      When user deletes employee id
      And user clicks on save button
      Then employee added successfully

  @today
     Scenario: third scenario of adding employee

       And user enters firstname middlename and lastname
       And user selects checkbox
       And user enters username password and confirmpassword
       And user clicks on save button
       Then employee added successfully

@examples
Scenario Outline:
  And user enters "<firstname>" "<middlename>" and "<lastname>" for an employee
  And user clicks on save button
  Then employee added successfully
  Examples:
  |firstname|middlename|lastname|
  |mike5472 | mm | lopppez   |
  |nailya837|jdj |kkd |
  |sule8764|gg|ozz|

  @datatable
Scenario: adding employee using data table
  When I add multiple employees and verify that user has been added successfully
    |firstname|middlename|lastname|
    |mike5472 | mm | lopppez   |
    |nailya837|jdj |kkd |
    |sule8764|gg|ozz|
    |2nailya837|j2dj |2kkd |
    |2sule8764|g2g|o2zz|

@excel
Scenario: Adding employees fro excel file
  When user adds multiple employees from excel file using "EmployeeData" sheet and verify the added employee




