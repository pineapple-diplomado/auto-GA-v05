
Feature: Verifications in Task


  Scenario: HomePage is displayed once set credential in JiraLoginPage page
    Given 'JiraLoginPage' page is loaded
    And set my credentials on 'JiraLoginPage' page
    And Click "ProyectoEjemplo" proyecto on HomePage page


