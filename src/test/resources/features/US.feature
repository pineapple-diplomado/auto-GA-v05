# Test cases for user stories operations

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

  Scenario Outline: Add time logged to user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    And rc Click on "<StoryName>" in 'Backlog' page
    And rc Click in 'Show more' button in 'Edit' panel
    And rc Click in 'Time Tracking' field in 'Edit' panel
    And rc Fill "1h" in time logged field in 'Time Tracking' dialog
    And rc Click 'Save' in 'Time Tracking' dialog

    Then rc Verify "<StoryNameCreated>" is created in 'Backlog' page
    Examples:
      | StoryName | StoryNameCreated |
      | US39      | US39             |

  Scenario Outline: Add linked story to user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName1>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName2>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    And rc Click on "<StoryName2>" in 'Backlog' page
    And rc Click in 'Link' button in 'Edit' panel
    And rc Click in 'Search for issues' field in 'Edit' panel
    And rc Fill item "<StoryName1>" in active issues in 'Edit' dialog
    And rc Click enter on item in active issues in 'Edit' dialog
    And rc Click 'Link' button in 'Linked issues' panel

    Examples:
      | StoryName1 | StoryName2 |
      | US51      | US52        |

  Scenario Outline: Add subtask to user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName1>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    And rc Click on "<StoryName1>" in 'Backlog' page
    And rc Click in 'Create subtask' button in 'Edit' panel
    And rc Click in 'Subtasks' field in 'Edit' panel
    And rc Fill item "<Subtask>" in 'Subtasks' field in 'Edit' dialog
    And rc Click in 'Create' button in 'Subtasks' field in 'Edit' dialog

    Examples:
      | StoryName1 | Subtask |
      | US55      | Subtask1 |