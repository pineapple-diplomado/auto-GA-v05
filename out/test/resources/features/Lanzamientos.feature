# Jira Lanzamiento/Release feature
Feature: Lanzamiento

  Background: Load page
    Given 'Jira' page is loaded

  Scenario: Lanzamiento page is displayed after load main page of Jira
    And start login by email
    And go to lanzamiento
    And open new Release Form
    And submit Form

  Scenario: Go to edit form and edit a release
    And Go to Editar
    And submit EditForm

  Scenario: Open delete and delete a release
    And Go to Eliminar

  Scenario: Create Version with name and comment
    And open new Release Form
    And submit Form with comment

  Scenario: Go to edit form and edit with comments
    And Go to Editar
    And submit EditForm with comment

  Scenario: Open Archive and archive a release
    And Go to Archive


  Scenario: Create Version with especial char
    And open new Release Form
    And submit Form with especial chars in title
    And Go to Publish
    And Publish



