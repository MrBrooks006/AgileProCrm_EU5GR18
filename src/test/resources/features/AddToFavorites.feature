Feature: Workgroup functions on ActivityStream
  @AGIL-247
#	Scenario Outline: Bilal-add groups to favorites

  Scenario Outline: <userType> should be able to add groups to favorite
    Given the user is on the login page
    And the "<userType>" enters the valid credentials and logs in
    When the user navigates to "Workgroups" tab
    And the user adds the "<groupType>" to favorites
    Then the user verifies that the "<groupType>" added to favorites
    Examples:
      | userType  | groupType                        |
		#      | hr        | "New Corporate Identity" project |
      | hr        | Corporate Christmas Party        |
      | hr        | New company web site development |
      | hr        | New product development          |
      | hr        | PR and advertising               |
      | hr        | Sales                            |
      | hr        | Soccer team                      |
      | hr        | Technology                       |
		#      | marketing | "New Corporate Identity" project |
      | marketing | Corporate Christmas Party        |
      | marketing | New company web site development |
      | marketing | New product development          |
      | marketing | PR and advertising               |
      | marketing | Sales                            |
      | marketing | Soccer team                      |
      | marketing | Technology                       |
		#      | helpdesk  | "New Corporate Identity" project |
      | helpdesk  | Corporate Christmas Party        |
      | helpdesk  | New company web site development |
      | helpdesk  | New product development          |
      | helpdesk  | PR and advertising               |
      | helpdesk  | Sales                            |
      | helpdesk  | Soccer team                      |
      | helpdesk  | Technology                       |