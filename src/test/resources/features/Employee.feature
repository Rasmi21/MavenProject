#Author: SyntaxTeam
@Employee
Feature: Employee

  Background: 
    Given I logged into OrangeHRM

  @Smoke
  Scenario Outline: Add Employee
    And I navigated to the Add Employee Page
    When I provide "<firstName>" and "<middleName>" and "<lastName>"
    Then I successfully added an employee

    Examples: 
      | firstName | middleName | lastName |
      | Alex      | S          | Smith    |
      | Jane      | H          | Han      |
      | Michael   | J          | Jackson  |

  @Temp
  Scenario: Modify Employee
    And I navigated to the Employee List Page
    When I search for employee "Michael J Jackson"
    And I select "Michael J Jackson"
    Then I can edit Employee information
      | driverLicense | licenseExpDate | maritalStatus | nationality | dob        |
      |       1234567 | 2019-12-01     | Single        | Australian  | 1975-12-31 |

  @Regression
  Scenario Outline: Delete Employee
    And I navigated to the Add Employee Page
    When I provide "<firstName>" and "<middleName>" and "<lastName>"
    And I successfully added an employee
    And I navigated to the Employee List Page
    Then I can delete employee

    Examples: 
      | firstName | middleName | lastName |
      | Angel     | S          | Williams |
      | Margaret  | S          | Anderson |
