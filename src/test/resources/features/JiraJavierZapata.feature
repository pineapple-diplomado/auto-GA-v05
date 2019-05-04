
Feature: Verifications in Task

#testcase2
    Scenario: Verification of a created task displayed on BackLog page
      Given 'JiraLoginPage' page is loaded
      And jz set my credentials on 'JiraLoginPage' page
      And jz Click "Crear incidencia" boton on BackLog page
      And jz Click OpenCreateDialog boton on BackLog page
      And jz Select 'Task' option on CreationTaskDialog dialog
      And jz Insert "Nuevo Task9" input on CreationTaskDialog dialog
      And jz Click 'Create' button on CreationTaskDialog dialog
      Then jz Check "Nuevo Task9" in List on BackLog page


#testcase5
    Scenario: Verification of changing status into InProgress
      Given 'JiraLoginPage' page is loaded
      And jz set my credentials on 'JiraLoginPage' page
      And jz Select "Nuevo Task9" task on BackLog page
      And jz Select 'InProgress' in status on PanelConfigurationTask page
      Then jz Check 'InProgrees' in status on PanelConfigurationTask page


#testcase12
    Scenario: Verification of opening dialog of SubTask
      Given 'JiraLoginPage' page is loaded
      And jz set my credentials on 'JiraLoginPage' page
      And jz Select "Nuevo Task9" task on BackLog page
      And jz Click 'Create sub task' icon on PanelConfigurationTask page
      Then jz Check 'Subtareas' label displayed on PanelConfigurationTask page


#testcase13
  Scenario: Verification of creating a SubTask
    Given 'JiraLoginPage' page is loaded
    And jz set my credentials on 'JiraLoginPage' page
    And jz Select "Nuevo Task9" task on BackLog page
    And jz Click 'Create sub task' icon on PanelConfigurationTask page
    And jz Insert "Nuevo subtask creado" field subTask on PanelConfigurationTask page
    And jz Click 'Crear' button on PanelConfigurationTask page
    Then jz Check "Nuevo subtask creado" field subTask on PanelConfigurationTask page


#testcase17
  Scenario: Verification of closing configuration panel
    Given 'JiraLoginPage' page is loaded
    And jz set my credentials on 'JiraLoginPage' page
    And jz Select "Nuevo Task9" task on BackLog page
    Then jz Click 'Close' icon on PanelConfigurationTask page


#testcase18
  Scenario: Verification of displaying issues per user
    Given 'JiraLoginPage' page is loaded
    And jz set my credentials on 'JiraLoginPage' page
    Then jz Click 'Only my issues' button with user "Javier Zapata" on BackLog page


#testcase3
  Scenario: Verification of creation a comment
    Given 'JiraLoginPage' page is loaded
    And jz set my credentials on 'JiraLoginPage' page
    And jz Select "Nuevo Task9" task on BackLog page
    Then jz Add "Mi nuevo comentario." in comment on PanelConfigurationTask page


#testcase23
  Scenario: Verification of deleting a comment
    Given 'JiraLoginPage' page is loaded
    And jz set my credentials on 'JiraLoginPage' page
    And jz Select "Nuevo Task9" task on BackLog page
    Then jz Click "Mi nuevo comentario" on comment on PanelConfigurationTask page


