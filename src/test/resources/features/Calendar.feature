@AGIL-250
Feature:

    #US:
    #As a user, I should be able to use Calendar function on Activity Stream
    #
    #Acceptance criteria:
    #1.User should be able to display My Calendar by clicking "My Calendar" tab
    #2.User should be able to display Company Calendar by clicking "Company Calendar" tab.
  @AGIL-244

Feature: Calendar functionality
  Scenario Outline: As a user, I should be able to use Calendar function on Activity Stream

Given the user logged in as "<userType>"
When the user navigates to "Calendar" menu
When the user navigates to "<tab>"
Then the title contains "<subtitle>"

Examples:
| userType  | tab              | subtitle         |
| marketing | My Calendar      | My Calendar      |
| marketing | Company Calendar | Company Calendar |
| helpdesk  | My Calendar      | My Calendar      |
| helpdesk  | Company Calendar | Company Calendar |
| hr        | My Calendar      | My calendar      |
| hr        | Company Calendar | Company Calendar |