@AGIL-253
Feature:

  Background:


	#{color:#4c9aff}*User Story*{color}
	#
	#As a user, I should be able to use Tasks function on Activity Stream
	#
	#
	#
	#{color:#4c9aff}*Acceptance Criteria*{color}
	#
	#*1.User should be able to display tasks "In Progress" by clicking "All Tasks" tab*
	#2.User should be able to display tasks "Ongoing Tasks" by clicking "Ongoing Tasks" tab
  @AGIL-251
  Scenario Outline: Verify that user should be able to display tasks "In Progress"



    Given the user logged in as "<userType>"
    When the user navigates to "Tasks" menu
    And the user navigates to "<tab>"
    Then the page contains "<buttonTitle>"

    Examples:
      | userType  | tab | buttonTitle |
      | marketing | All | In progress |
      | helpdesk  | All | In progress |
      | hr        | All | In progress |

	#{color:#4c9aff}*User Story*{color}
	#
	#As a user, I should be able to use Tasks function on Activity Stream
	#
	#{color:#4c9aff}*Acceptance Criteria*{color}
	#1.User should be able to display tasks "In Progress" by clicking "All Tasks" tab
	#*2.User should be able to display tasks "Ongoing Tasks" by clicking "Ongoing Tasks" tab*
  @AGIL-252
  Scenario Outline: Verify that user should be able to display tasks "Ongoing Tasks"


    Given the user logged in as "<userType>"
    When the user navigates to "Tasks" menu
    When the user navigates to "<tab>"
    And the search submit box is clean
    Then the page contains "<buttonTitle>"

    Examples:
      | userType  | tab     | buttonTitle   |
      | marketing | Ongoing | Role: Ongoing |
      | helpdesk  | Ongoing | Role: Ongoing |
      | hr        | Ongoing | Role: Ongoing |
