@AGIL-243
Feature:

  Background:


	#*{color:#de350b}1.User should be able to display "Edit User Profile" window by clicking on "Edit Profile Settings" menu.{color}*
	#2.User should be able to display "Contact Information" by clicking on "My Profile" menu
  @AGIL-239
  Scenario Outline: Verify that <userType> is able to display "Edit User Profile"

    Given user is logged in with "<username>" and "<password>"
    When user clicks on "Edit Profile Setting"
    Then user should able to see Edit User Profile

    Examples:
      |userType       |username                      |password|
      |hr             |hr1@cybertekschool.com        |UserUser|
      |hr             |hr22@cybertekschool.com       |UserUser|
      |hr             |hr55@cybertekschool.com       |UserUser|
      |help desk      |helpdesk1@cybertekschool.com  |UserUser|
      |help desk      |helpdesk22@cybertekschool.com |UserUser|
      |help desk      |helpdesk55@cybertekschool.com |UserUser|
      |marketing      |marketing1@cybertekschool.com |UserUser|
      |marketing      |marketing22@cybertekschool.com|UserUser|
      |marketing      |marketing55@cybertekschool.com|UserUser|


	#1.User should be able to display "Edit User Profile" window by clicking on "Edit Profile Settings" menu.
	#{color:#de350b}*2.User should be able to display "Contact Information" by clicking on "My Profile" menu*{color}
  @AGIL-240
  Scenario Outline: Verify that <userType> is able to display "Contact Information"
    Given user is logged in with "<username>" and "<password>"
    When user clicks on "My Profile"
    Then user should able to see Contact Information

    Examples:
      |userType       |username                      |password|
      |hr             |hr1@cybertekschool.com        |UserUser|
      |hr             |hr22@cybertekschool.com       |UserUser|
      |hr             |hr55@cybertekschool.com       |UserUser|
      |help desk      |helpdesk1@cybertekschool.com  |UserUser|
      |help desk      |helpdesk22@cybertekschool.com |UserUser|
      |help desk      |helpdesk55@cybertekschool.com |UserUser|
      |marketing      |marketing1@cybertekschool.com |UserUser|
      |marketing      |marketing22@cybertekschool.com|UserUser|
      |marketing      |marketing55@cybertekschool.com|UserUser|