Feature:Use Drive function on Activity Stream

  @drive
  Scenario Outline:Display different <tab>

    Given the user logged in as "<userType>"
    When the user navigates to "<tab>"
    Then the title contains "<title>"

    Examples:
      |userType                     |tab          |title        |
      |marketing1@cybertekschool.com|My Drive     |My Drive     |
      |marketing2@cybertekschool.com|My Drive     |My Drive     |
      |marketing3@cybertekschool.com|My Drive     |My Drive     |
      |marketing1@cybertekschool.com|Company Drive|Company drive|
      |marketing2@cybertekschool.com|Company Drive|Company drive|
      |marketing3@cybertekschool.com|Company Drive|Company drive|
      |helpdesk1@cybertekschool.com |My Drive     |My Drive     |
      |helpdesk2@cybertekschool.com |My Drive     |My Drive     |
      |helpdesk3@cybertekschool.com |My Drive     |My Drive     |
      |helpdesk1@cybertekschool.com |Company Drive|Company drive|
      |helpdesk2@cybertekschool.com |Company Drive|Company drive|
      |helpdesk3@cybertekschool.com |Company Drive|Company drive|
      |hr1@cybertekschool.com       |My Drive     |My Drive     |
      |hr2@cybertekschool.com       |My Drive     |My Drive     |
      |hr3@cybertekschool.com       |My Drive     |My Drive     |
      |hr1@cybertekschool.com       |Company Drive|Company drive|
      |hr2@cybertekschool.com       |Company Drive|Company drive|
      |hr3@cybertekschool.com       |Company Drive|Company drive|

