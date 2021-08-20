Feature: Workgroup functions on ActivityStream

  @AGIL-254
  Scenario Outline: <userType> should be able to join groups
    Given the user is on the login page
    And the "<userType>" enters the valid credentials and logs in
    When the user navigates to "Workgroups" tab
    And the user joins the "<groupType>" group
    Then the user verifies she or he joint for "<groupType>"

    Examples:
      | userType  | groupType                        |
      | helpdesk  | Corporate Christmas Party        |
      | helpdesk  | New company web site development |
      | marketing | Technology                       |
      | hr        | Soccer team                      |