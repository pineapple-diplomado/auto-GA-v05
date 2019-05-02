
Feature: Verifications in Task


  Scenario: HomePage is displayed once set credential in JiraLoginPage page
    Given 'JiraLoginPage' page is loaded
    And set my credentials on 'JiraLoginPage' page
    And Click "ProyectoEjemplo" proyecto on HomePage page
    And Click "Crear incidencia" boton on BackLog page
    And Click OpenCreateDialog boton on BackLog page
    And Select 'Task' option on CreationTaskDialog dialog
    And Insert "Nuevo Task" input on CreationTaskDialog dialog
    And Click 'Create' button on CreationTaskDialog dialog
    Then Check "Nuevo Task" in List on BackLog page


