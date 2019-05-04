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

  #Scenario: Open delete and delete a release
  #  And Go to Eliminar

  #Scenario: Open Archive and archive a release
  #  And Go to Archive

  Scenario: Open Publish and publish a release
    And Go to Publish
    And Publish

  Scenario: Show Publish releases
    And Go to Select Filter
    And Select Publishes

  Scenario: Show Archive releases
    And Go to Select Filter
    And Select Archives
