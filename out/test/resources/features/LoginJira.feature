# Login feature review the behavior in this feature
Feature: Login

  @LogIn
  Scenario Outline: Login page is displayed once set credential in login page
    Given 'Jira' page is loaded
    And set "<email>" email field on 'Login' page
    And click 'Continue' button
    And set "<password>" password field on 'Login' page
    And click 'Log in' button

  Examples:
      |          email        | password |            url                 |
      |    isa.gric@gmail.com |sosiego14 | https://id.atlassian.com/login |
