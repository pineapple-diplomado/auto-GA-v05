# Jira Lanzamiento/Release feature
Feature: Lanzamiento

  Background: Load page
    Given 'Jira' page is loaded
    And start login by email

  Scenario: Lanzamiento page is displayed after load main page of Jira
    And go to lanzamiento
    And open new Release Form
    And submit Form