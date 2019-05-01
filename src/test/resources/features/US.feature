# Test cases to user stories operations

Feature: UserStory
  Background: User is logged in
    Given Main page "https://renecopaga.atlassian.net" is open
    And Set username "rene.copaga@gmail.com" in 'Login' page
    And Set password "Control123!" in 'Login' page
    And Open Proyecto page

  Scenario: 'Browse Projects' page is displayed after logged inw
    And rc Click on 'Create issue' button in 'Backlog' page
    And rc Fill "US11" in 'Create' dialog
    And rc Click on 'Create' button in 'Create' dialog
