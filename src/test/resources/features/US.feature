# Test cases to user stories operations

Feature: UserStory
  Background: User is logged in
    Given Main page "https://renecopaga.atlassian.net" is open
    And Set username "rene.copaga@gmail.com" in 'Login' page
    And Set password "Control123!" in 'Login' page
    And Open Proyecto page

  Scenario Outline: Create user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    Then rc Verify "<StoryNameCreated>" is created in 'Backlog' page
    Examples:
      | StoryName | StoryNameCreated |
      | US23    | US23 |

  Scenario Outline: Update status user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    And rc Click on "<StoryName>" in 'Backlog' page
    And rc Click in 'Status' in 'Edit' panel
    And rc Click in 'In Progress' in 'Edit' panel

    Then rc Verify "<StoryNameCreated>" is created in 'Backlog' page
    Examples:
      | StoryName | StoryNameCreated |
      | US29      | US29             |

  Scenario Outline: Add description to user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    And rc Click on "<StoryName>" in 'Backlog' page
    And rc Click in 'Description' in 'Edit' panel
    And rc Fill "A description" in description field in 'Edit' panel
    And rc Click in 'Save' in 'Edit' panel

    Then rc Verify "<StoryNameCreated>" is created in 'Backlog' page
    Examples:
      | StoryName | StoryNameCreated |
      | US30      | US30             |

  Scenario Outline: Add comment to user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    And rc Click on "<StoryName>" in 'Backlog' page
    And rc Click in 'Comment' in 'Edit' panel
    And rc Fill "A comment" in comment field in 'Edit' panel
    And rc Click in comment 'Save' in 'Edit' panel

    Then rc Verify "<StoryNameCreated>" is created in 'Backlog' page
    Examples:
      | StoryName | StoryNameCreated |
      | US31      | US31             |