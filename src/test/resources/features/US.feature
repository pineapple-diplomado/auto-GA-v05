# Test cases for user stories operations

Feature: UserStory
  Background: User is logged in
    Given Main page "https://renecopaga.atlassian.net" is open
    And Set username "rene.copaga@gmail.com" in 'Login' page
    And Set password "Control123!" in 'Login' page
    And rc Open Project page

  Scenario Outline: Create user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    Then rc Verify "<StoryNameCreated>" is created in 'Backlog' page
    Examples:
      | StoryName | StoryNameCreated |
      | US10    | US10 |

  Scenario Outline: Update status user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    And rc Click on "<StoryName>" in 'Backlog' page
    And rc Click in 'Status' in 'Edit' panel
    And rc Click in 'In Progress' in 'Edit' panel
    Then rc Verify "In Progress" status is set in 'Edit' page
    Examples:
      | StoryName |
      | US11      |

  Scenario Outline: Add description to user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    And rc Click on "<StoryName>" in 'Backlog' page
    And rc Click in 'Description' in 'Edit' panel
    And rc Fill "<DescriptionText>" in description field in 'Edit' panel
    And rc Click in 'Save' in 'Edit' panel

    Then rc Verify "<DescriptionText>" is set in 'Edit' page
    Examples:
      | StoryName | DescriptionText |
      | US12      | A description   |

  Scenario Outline: Add comment to user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    And rc Click on "<StoryName>" in 'Backlog' page
    And rc Click in 'Comment' in 'Edit' panel
    And rc Fill "<Comment>" in comment field in 'Edit' panel
    And rc Click in comment 'Save' in 'Edit' panel

    Then rc Verify "<Comment>" field is set in 'Edit' page
    Examples:
      | StoryName | Comment   |
      | US13      | A comment |

  Scenario Outline: Add time logged to user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    And rc Click on "<StoryName>" in 'Backlog' page
    And rc Click in 'Show more' button in 'Edit' panel
    And rc Click in 'Time Tracking' field in 'Edit' panel
    And rc Fill "<Time>" in time logged field in 'Time Tracking' dialog
    And rc Click 'Save' in 'Time Tracking' dialog

    Then rc Verify "<Time>" Time Tracking field is set in 'Edit' page
    Examples:
      | StoryName | Time |
      | US14      | 1h   |

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

    Then rc Verify "<StoryName1>" linked field is set in 'Edit' page

    Examples:
      | StoryName1 | StoryName2 |
      | US15      | US16        |

  Scenario Outline: Add subtask to user story
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "<StoryName1>" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
    And rc Click on "<StoryName1>" in 'Backlog' page
    And rc Click in 'Create subtask' button in 'Edit' panel
    And rc Click in 'Subtasks' field in 'Edit' panel
    And rc Fill item "<Subtask>" in 'Subtasks' field in 'Edit' dialog
    And rc Click in 'Create' button in 'Subtasks' field in 'Edit' dialog
    Then rc Verify "<Subtask>" subtask field is set in 'Edit' page
    Examples:
      | StoryName1 | Subtask |
      | US17      | Subtask1 |