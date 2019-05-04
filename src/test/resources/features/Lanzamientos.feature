# Jira Lanzamiento/Release feature
# TEST CASES WORKED TC-ER-1 TC-ER-2 TC-ER-3 TC-ER-6 TC-ER-9 TC-ER-10 TC-ER-15 TC-ER-16 TC-ER-17
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



