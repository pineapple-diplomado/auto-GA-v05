
Feature: Verifications in Task

##testcase2
#    Scenario: Verification of a created task displayed on BackLog page
#      Given 'JiraLoginPage' page is loaded
#      And set my credentials on 'JiraLoginPage' page
#      And Click "ProyectoEjemplo" proyecto on HomePage page
#      And Click "Crear incidencia" boton on BackLog page
#      And Click OpenCreateDialog boton on BackLog page
#      And Select 'Task' option on CreationTaskDialog dialog
#      And Insert "Nuevo Task" input on CreationTaskDialog dialog
#      And Click 'Create' button on CreationTaskDialog dialog
#      Then Check "Nuevo Task" in List on BackLog page
#
#
##testcase5
#    Scenario: Verification of changing status into InProgress
#      Given 'JiraLoginPage' page is loaded
#      And set my credentials on 'JiraLoginPage' page
#      And Click "ProyectoEjemplo" proyecto on HomePage page
#      And Select "Nuevo Task" task on BackLog page
#      And Select 'InProgress' in status on PanelConfigurationTask page
#      Then Check 'InProgrees' in status on PanelConfigurationTask page
#
#
##testcase12
#    Scenario: Verification of opening dialog of SubTask
#      Given 'JiraLoginPage' page is loaded
#      And set my credentials on 'JiraLoginPage' page
#      And Click "ProyectoEjemplo" proyecto on HomePage page
#      And Select "Nuevo Task" task on BackLog page
#      And Click 'Create sub task' icon on PanelConfigurationTask page
#      Then Check 'Subtareas' label displayed on PanelConfigurationTask page
#
#
##testcase13
#  Scenario: Verification of creating a SubTask
#    Given 'JiraLoginPage' page is loaded
#    And set my credentials on 'JiraLoginPage' page
#    And Click "ProyectoEjemplo" proyecto on HomePage page
#    And Select "Nuevo Task" task on BackLog page
#    And Click 'Create sub task' icon on PanelConfigurationTask page
#    And Insert "Nuevo subtask creado" field subTask on PanelConfigurationTask page
#    And Click 'Crear' button on PanelConfigurationTask page
#    Then Check "Nuevo subtask creado" field subTask on PanelConfigurationTask page
#
#
##testcase17
#  Scenario: Verification of closing configuration panel
#    Given 'JiraLoginPage' page is loaded
#    And set my credentials on 'JiraLoginPage' page
#    And Click "ProyectoEjemplo" proyecto on HomePage page
#    And Select "Nuevo Task2" task on BackLog page
#    Then Click 'Close' icon on PanelConfigurationTask page
#
#
##testcase18
#  Scenario: Verification of displaying issues per user
#    Given 'JiraLoginPage' page is loaded
#    And set my credentials on 'JiraLoginPage' page
#    And Click "ProyectoEjemplo" proyecto on HomePage page
#    Then Click 'Only my issues' button with user "Javier Zapata" on BackLog page


#testcase23
  Scenario: Verification of deleting a comment
    Given 'JiraLoginPage' page is loaded
    And set my credentials on 'JiraLoginPage' page
    And Click "ProyectoEjemplo" proyecto on HomePage page
    And Select "Nuevo Task1" task on BackLog page
    Then Click "Mi nuevo comentario V2" on comment on PanelConfigurationTask page
