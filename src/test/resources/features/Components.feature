Feature: Components option

  Scenario: Redirect to Components page TestCase1
    Given am Jira home page is loaded
    And am User is logged in
    And am click 'Components' option on 'Main page' of Jira
    Then am verify that the title of the page should be "Components"

  Scenario: Create a new component
    And am Component page loaded
    And am click 'Create Component' button on 'Components page'
    And am set the name field with "Frontend side 14" on 'CreateComponentDialog'
    And am set the description field with "Home component" on 'CreateComponentDialog'
    And am set the default lead field with "Component lead (Unassigned)" on 'CreateComponentDialog'
    Then am click 'Save' button on 'CreateComponentDialog'

  Scenario: Click outside of the create component form
    And am Component page loaded
    And am click 'Create Component' button on 'Components page'
    And am click outside of 'CreateComponentDialog'
    Then am verify that the title of the page should be "Components"

  Scenario: Create a new Component and Cancel button is enable
    And am Component page loaded
    And am click 'Create Component' button on 'Components page'
    Then am verify that 'Cancel' button should be disabled on 'CreateComponentDialog'

  Scenario: Delete the name of a component created
    And am Component page loaded
    And am edit the last component created on 'Component page'
    And am delete the name on 'Edit component dialog'
    Then am verify that the 'Save' button should be disable on 'Edit component dialog'

  Scenario: Edit the component
    And am Component page loaded
    And am edit the last component created on 'Component page'
    And am set the description field with "Login component" on 'Edit component dialog'
    And am set the default lead field with "Project lead (pineapple automation)" on 'Edit component dialog'
    When am click 'Save' button on 'Edit component dialog'

  Scenario: Find a specific component
    And am Component page loaded
    And am find "Frontend side 14" on 'Components page'
    Then am verify that 'Component page' should show "Frontend side 14" component

  Scenario: Delete the component called "Frontend side 14"
    And am Component page loaded
    And am delete the last component created on 'Component page'
    Then am verify the "Frontend side 14" was deleted on 'Component page'




