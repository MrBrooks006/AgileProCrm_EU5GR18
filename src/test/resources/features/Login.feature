
Feature: Login functionality

  Scenario Outline: Login with valid credentials "<userType>"
    Given the user is on the login page
    When the user enters valid "<login>" and "<password>"
    Then the user should log in into the home page


    Examples:
      |   userType    |   login                            |   password   |
      |   helpdesk    |   helpdesk1@cybertekschool.com     |   UserUser   |
      |   helpdesk    |   helpdesk99@cybertekschool.com    |   UserUser   |
      |   helpdesk    |   helpdesk101@cybertekschool.com   |   UserUser   |
      |   hr          |   hr1@cybertekschool.com           |   UserUser   |
      |   hr          |   hr99@cybertekschool.com          |   UserUser   |
      |   hr          |   hr100@cybertekschool.com         |   UserUser   |
      |   marketing   |   marketing2@cybertekschool.com    |   UserUser   |
      |   marketing   |   marketing99@cybertekschool.com   |   UserUser   |
      |   marketing   |   marketing101@cybertekschool.com  |   UserUser   |

    @wip
  Scenario Outline: Login with invalid credentials "<userType>"
    Given the user is on the login page
    When the user enters invalid "<login>" and "<password>"
    Then system should show the error message
    And the user should stay on the login page

    Examples:
      |   userType    |   login                            |   password    |
      |   helpdesk    |   wkmhelpdesk1@cybertekschool.com  |   UserUser    |
      |   helpdesk    |   helpdesk99@cybertekschool.com    |   UserUserwp  |
      |   helpdesk    |   ghelpdesk101@cybertekschool.com  |   UserUser43  |
      |   hr          |   4h*hr1@cybertekschool.com        |   UserUser    |
      |   hr          |   hr99@cybertekschool.com          |   UserUser53  |
      |   hr          |   t6*hr100@cybertekschool.com      |   UserUser2y  |
      |   marketing   |   k6*marketing2@cybertekschool.com |   UserUser    |
      |   marketing   |   marketing99@cybertekschool.com   |   8UserUser   |
      |   marketing   |   4rketing101@cybertekschool.com   |   UserUserA   |
      |               |                                    |               |
