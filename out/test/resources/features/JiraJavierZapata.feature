
Feature: Verifications in Task

##testcase2
#  Scenario: Verification of a created task displayed on BackLog page
#    Given 'JiraLoginPage' page is loaded
#    And set my credentials on 'JiraLoginPage' page
#    And Click "ProyectoEjemplo" proyecto on HomePage page
#    And Click "Crear incidencia" boton on BackLog page
#    And Click OpenCreateDialog boton on BackLog page
#    And Select 'Task' option on CreationTaskDialog dialog
#    And Insert "Nuevo Task" input on CreationTaskDialog dialog
#    And Click 'Create' button on CreationTaskDialog dialog
#    Then Check "Nuevo Task" in List on BackLog page
#
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

#testcase9
    Scenario: Verification of changing name of a task
      Given 'JiraLoginPage' page is loaded
      And set my credentials on 'JiraLoginPage' page
      And Click "ProyectoEjemplo" proyecto on HomePage page
      And Select "Nuevo Task" task on BackLog page
      And Click 'Create sub task' icon on PanelConfigurationTask page
      Then Check 'Subtareas' label displayed on PanelConfigurationTask page

