Feature: Components option

  Background: Jira page is loaded and user logged in
    Given Jira page "https://medrano.atlassian.net" is loaded
    And User is logged in
    And select the project on 'Project page'

  Scenario: Redirect to Components page TestCase1
    When click 'Components' option on 'Main page' of Jira
    Then verify that the title of the page should be "Components"

  Scenario: Create a new Component and Cancel button is enable
    And click 'Components' option on 'Main page' of Jira
    And click 'Create Component' button on 'Components page'
    Then verify that 'Cancel' button should be disabled on 'CreateComponentDialog'

  Scenario: Create a new component
    And click 'Components' option on 'Main page' of Jira
    And click 'Create Component' button on 'Components page'
    And set the name field with "Frontend side 14" on 'CreateComponentDialog'
    And set the description field with "Home component" on 'CreateComponentDialog'
    And set the default lead field with "Component lead (Unassigned)" on 'CreateComponentDialog'
    When click 'Save' button on 'CreateComponentDialog'
    Then verifying created "Frontend side 14"component on 'Component page'

  Scenario: Click outside of the create component form
    And click 'Components' option on 'Main page' of Jira
    And click 'Create Component' button on 'Components page'
    And click outside of 'CreateComponentDialog'
    Then verify that the title of the page should be "Components"

  Scenario: Delete the name of a component created
    And click 'Components' option on 'Main page' of Jira
    And edit the last component created on 'Component page'
    And delete the name on 'Edit component dialog'
    Then verify that the 'Save' button should be disable on 'Edit component dialog'

  Scenario: Edit the component
    And click 'Components' option on 'Main page' of Jira
    And edit the last component created on 'Component page'
    And set the description field with "Login component" on 'Edit component dialog'
    And set the default lead field with "Project lead (Ana Medrano)" on 'Edit component dialog'
    When click 'Save' button on 'Edit component dialog'
    Then verify that description should be "Login component" on 'Component page'

  Scenario: Find a specific component
    And click 'Components' option on 'Main page' of Jira
    And find "Frontend side 14" on 'Components page'
    Then verify that 'Component page' should show "Frontend side 14" component

  Scenario: Delete the component called "Frontend side 5"
    And click 'Components' option on 'Main page' of Jira
    And delete the last component created on 'Component page'
    Then verify the "Frontend side 8" was deleted on 'Component page'




