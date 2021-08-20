@wip
Feature: Use Tasks function on Activity Stream


  Scenario Outline: As <userType> user, display <tab> tab

    Given the user logged in as "<userType>"
    When the user navigates to "Tasks" menu
    And the user navigates to "<tab>"
    Then the page contains "<buttonTitle>"

    Examples:
      | userType  | tab | buttonTitle |
      | marketing | All | In progress |
      | helpdesk  | All | In progress |
      | hr        | All | In progress |




  Scenario Outline: As <userType> user, display <tab> tab

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