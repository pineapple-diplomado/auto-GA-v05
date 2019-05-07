# Jira Lanzamiento/Release feature
# TEST CASES WORKED TC-ER-1 TC-ER-2 TC-ER-3 TC-ER-6 TC-ER-9 TC-ER-10 TC-ER-15 TC-ER-16 TC-ER-17
Feature: Lanzamiento

  Background: Load page
    Given er 'Jira' lanzamiento page is loaded

  Scenario: Lanzamiento page is displayed after load main page of Jira
    And er start login by email
    And er go to lanzamiento
    And er open new Release Form
    And er submit Form

  Scenario: Go to edit form and edit a release
    And er Go to Editar
    And er submit EditForm

  Scenario: Open delete and delete a release
    And er Go to Eliminar

  Scenario: Create Version with name and comment
    And er open new Release Form
    And er submit Form with comment

  Scenario: Go to edit form and edit with comments
    And er Go to Editar
    And er submit EditForm with comment

  Scenario: Open Archive and archive a release
    And er Go to Archive


  Scenario: Create Version with especial char
    And er open new Release Form
    And er submit Form with especial chars in title
    And er Go to Publish
    And er Publish



