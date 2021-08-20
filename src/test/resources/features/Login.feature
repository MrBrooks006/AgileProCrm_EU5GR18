@AGIL-245
Feature: 

    #{color:#de350b}US:{color}
    #
    #As a user, I should be able to login.
    #
    # 
    #
    #{color:#de350b}Acceptance criteria:{color}
    #
    #1.User should be able to login as HR user with Valid Credentials
    #2.User should be able to login as Helpdesk user with Valid Credentials
    #3.User should be able to login as Marketing user with Valid Credentials.
  @AGIL-237
  Scenario Outline: Login functionality (With valid Login and Password) for AUTOMATION
Feature: Login functionality

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