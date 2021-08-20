@AGIL-249
Feature:

    #{color:#de350b}US:{color}
    #
    #As a user, I should be able to login.
    #
    #
    #
    #{color:#de350b}Acceptance criteria: {color}
    #
    #1.Users should not be able to login with invalid credentials
    #
    #2.Users should not be able to login with blank credentials
  @AGIL-238
  Scenario Outline: Login functionality (with invalid Login and/or Password) for AUTOMATION
Feature: Login functionality

Given the user is on the login page
When the user enters invalid "<login>" and "<password>"
Then system should show the error message
And the user should stay on the login page

Examples:
|   userType    |   login                            |   password    |
|   helpdesk    |   wkmhelpdesk1@cybertekschool.com  |   UserUser    |
|   helpdesk    |   helpdesk99@cybertekschool.com    |   UserUserwp  |
|   helpdesk    |   ghelpdesk101@cybertekschool.com  |   UserUser43  |
|   hr          |   4hhr1@cybertekschool.com        |   UserUser    |
|   hr          |   hr99@cybertekschool.com          |   UserUser53  |
|   hr          |   t6hr100@cybertekschool.com      |   UserUser2y  |
|   marketing   |   k6*marketing2@cybertekschool.com |   UserUser    |
|   marketing   |   marketing99@cybertekschool.com   |   8UserUser   |
|   marketing   |   4rketing101@cybertekschool.com   |   UserUserA   |
|               |                                    |               |