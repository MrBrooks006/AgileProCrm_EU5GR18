@AGIL-236

Feature:Use Drive function on Activity Stream

  Scenario Outline:Display different <tab>

    Given the user logged in as "<userType>"
    When the user navigates to "Drive" menu
    When the user navigates to "<tab>"
    Then the title contains "<title>"

    Examples:
      | userType  | tab           | title         |
      | marketing | My Drive      | My Drive      |
      | marketing | Company Drive | Company drive |
      | helpdesk  | My Drive      | My Drive      |
      | helpdesk  | Company Drive | Company drive |
      | hr        | My Drive      | My Drive      |
      | hr        | Company Drive | Company drive |
		
		
		
		
		
		
		
		