package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.userstories.UserStoryLogin;
import org.umssdiplo.automationv01.core.managepage.userstories.*;
import org.umssdiplo.automationv01.core.managepage.userstories.UserStoryLoadPage;

public class UserStoryStepsDefinition {
    private UserStoryLogin userStoryLogin;
    private UserStoryBacklog userStoryBacklog;
    private UserStoryBrowseProjects userStoryBrowseProjects;
    private UserStoryDialogItemCreation userStoryDialogItemCreation;
    private UserStoryPanelItem useStoryPanelItem;

    @Given("^Main page is open$")
    public void mainPageIsOpen() throws InterruptedException {
        userStoryLogin = UserStoryLoadPage.loginPage();
        Thread.sleep(5000);
        try {
            userStoryLogin.setEmail();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        Thread.sleep(5000);
        try {
            userStoryLogin.setPassword();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @And("^Set username in 'Login' page$")
    public void setUsernameInLoginPage() throws InterruptedException {
        Thread.sleep(5000);
        try {
            userStoryLogin.setEmail();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @And("^Set password in 'Login' page$")
    public void setPasswordInLoginPage() throws InterruptedException {
        Thread.sleep(5000);
        try {
            userStoryLogin.setPassword();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

/*
    @And("^Create project \"([^\"]*)\" in 'Browse' page$")
    public void createProjectInBrowsePage(String projectName) throws Throwable {
        Thread.sleep(5000);
        userStoryBrowseProjects.clickCreateProject();
        Thread.sleep(8000);
        userStoryBrowseProjects.selectClassicProject();
        Thread.sleep(8000);
        userStoryBrowseProjects.fillProjectName(projectName);
        Thread.sleep(8000);
        userStoryBrowseProjects.hoverCreateProjectButton();
        Thread.sleep(5000);
        userStoryBrowseProjects.clickCreateProjectButton();
        Thread.sleep(10000);
        projectUrl = userStoryBrowseProjects.getProjectUrl(projectName);
        Thread.sleep(5000);
    }
*/
    @And("^rc Open Project page$")
    public void rcOpenProjectPage() throws InterruptedException {
        Thread.sleep(5000);
        UserStoryLoadPage.openBacklogProject();
        userStoryBacklog = new UserStoryBacklog();
    }

    @And("^rc Click on 'Create issue' button in 'Backlog' page$")
    public void rcClickOnCreateIssueButtonInBacklogPage() {
        userStoryDialogItemCreation = userStoryBacklog.clickCreateIssueBtn();
    }

    @And("^rc Fill \"([^\"]*)\" in 'Create' dialog$")
    public void rcFillInCreateDialog(String summary) throws Throwable {
        userStoryDialogItemCreation.fillText(summary);
    }

    @And("^rc Click on 'Create' button in 'Create' dialog$")
    public void rcClickOnCreateButtonInCreateDialog() throws InterruptedException {
        userStoryDialogItemCreation.clickCreateDialogButton();
        Thread.sleep(5000);
    }

    @Then("^rc Verify \"([^\"]*)\" is created in 'Backlog' page$")
    public void verifyIsCreatedInBacklogPage(String expectedStoryName) throws Throwable {
        Thread.sleep(5000);
        String actualStoryName = userStoryBacklog.getFirstStory();

        Assert.assertEquals(actualStoryName, expectedStoryName);
        Thread.sleep(5000);
    }

    @And("^rc Click on \"([^\"]*)\" in 'Backlog' page$")
    public void rcClickOnInBacklogPage(String storyName) throws Throwable {
        useStoryPanelItem = userStoryBacklog.clicOnItem(storyName);
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Status' in 'Edit' panel$")
    public void rcClickInStatusInEditPanel() throws InterruptedException {
        useStoryPanelItem.clickOnStatus();
        Thread.sleep(5000);
    }

    @And("^rc Click in 'In Progress' in 'Edit' panel$")
    public void rcClickInInProgressInEditPanel() throws InterruptedException {
        useStoryPanelItem.clickOnStatusInProgress();
        Thread.sleep(5000);
    }

    @Then("^rc Verify \"([^\"]*)\" status is set in 'Edit' page$")
    public void rcVerifyStatusIsSetInEditPage(String expectedStatus) throws Throwable {
        String actualStatus = useStoryPanelItem.getStatusText();
        Assert.assertEquals(actualStatus, expectedStatus);
    }

    @And("^rc Click in 'Description' in 'Edit' panel$")
    public void rcClickInDescriptionInEditPanel() throws InterruptedException {
        useStoryPanelItem.clickOnDescription();
        Thread.sleep(5000);
    }

    @And("^rc Fill \"([^\"]*)\" in description field in 'Edit' panel$")
    public void rcFillInDescriptionFieldInEditPanel(String text) throws Throwable {
        useStoryPanelItem.fillOnDescription(text);
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Save' in 'Edit' panel$")
    public void rcClickInSaveInEditPanel() throws InterruptedException {
        useStoryPanelItem.clickOnSaveDescription();
        Thread.sleep(5000);
    }

    @Then("^rc Verify \"([^\"]*)\" is set in 'Edit' page$")
    public void rcVerifyIsSetInEditPage(String expectedDescription) throws Throwable {
        String actualDescription = useStoryPanelItem.getDescriptionValue(expectedDescription);
        Assert.assertEquals(expectedDescription, actualDescription);
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Comment' in 'Edit' panel$")
    public void rcClickInCommentInEditPanel() throws InterruptedException {
        useStoryPanelItem.clickOnComment();
        Thread.sleep(5000);
    }

    @And("^rc Fill \"([^\"]*)\" in comment field in 'Edit' panel$")
    public void rcFillInCommentFieldInEditPanel(String text) throws Throwable {
        useStoryPanelItem.fillOnComment(text);
        Thread.sleep(5000);
    }

    @And("^rc Click in comment 'Save' in 'Edit' panel$")
    public void rcClickInCommentSaveInEditPanel() throws InterruptedException {
        useStoryPanelItem.clickOnSaveComment();
        Thread.sleep(5000);
    }

    @Then("^rc Verify \"([^\"]*)\" field is set in 'Edit' page$")
    public void rcVerifyFieldIsSetInEditPage(String expectedComment) throws Throwable {
        String actualComment = useStoryPanelItem.getCommentValue(expectedComment);
        Assert.assertEquals(expectedComment, actualComment);
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Show more' button in 'Edit' panel$")
    public void rcClickInShowMoreButtonInEditPanel() throws InterruptedException {
        useStoryPanelItem.clickOnShowMore();
        Thread.sleep(5000);
        useStoryPanelItem.clickOnShowMore();
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Time Tracking' field in 'Edit' panel$")
    public void rcClickInTimeTrackingFieldInEditPanel() throws InterruptedException {
        useStoryPanelItem.clickOnTimeLogged();
        Thread.sleep(5000);
    }

    @And("^rc Fill \"([^\"]*)\" in time logged field in 'Time Tracking' dialog$")
    public void rcFillInTimeLoggedFieldInTimeTrackingDialog(String text) throws Throwable {
        useStoryPanelItem.fillTimeLogged(text);
        Thread.sleep(5000);
    }

    @And("^rc Click 'Save' in 'Time Tracking' dialog$")
    public void rcClickSaveInTimeTrackingDialog() throws InterruptedException {
        useStoryPanelItem.clickOnSaveTimeLogged();
        Thread.sleep(5000);
    }

    @Then("^rc Verify \"([^\"]*)\" Time Tracking field is set in 'Edit' page$")
    public void rcVerifyTimeTrackingFieldIsSetInEditPage(String expectedTime) throws Throwable {
        String actualTime = useStoryPanelItem.getTimeLoggedValue(expectedTime);
        Assert.assertEquals(expectedTime, actualTime);
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Link' button in 'Edit' panel$")
    public void rcClickInLinkButtonInEditPanel() throws InterruptedException {
        useStoryPanelItem.clickOnLinkButton();
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Search for issues' field in 'Edit' panel$")
    public void rcClickInSearchForIssuesFieldInEditPanel() throws InterruptedException {
        useStoryPanelItem.clickOnSearchIssues();
        Thread.sleep(5000);
    }

    @And("^rc Click 'Link' button in 'Linked issues' panel$")
    public void rcClickLinkButtonInLinkedIssuesPanel() {
        useStoryPanelItem.clickOnSaveLink();
    }

    @And("^rc Fill item \"([^\"]*)\" in active issues in 'Edit' dialog$")
    public void rcFillItemInActiveIssuesInEditDialog(String item) throws Throwable {
        String textItem = useStoryPanelItem.getTextSelectedItem(item);
        Thread.sleep(5000);
        useStoryPanelItem.fillLinkItem(textItem);
        Thread.sleep(5000);
    }

    @And("^rc Click enter on item in active issues in 'Edit' dialog$")
    public void rcClickEnterOnItemInActiveIssuesInEditDialog() throws InterruptedException {
        useStoryPanelItem.clickEnterLinkItem();
        Thread.sleep(5000);
    }

    @Then("^rc Verify \"([^\"]*)\" linked field is set in 'Edit' page$")
    public void rcVerifyLinkedFieldIsSetInEditPage(String expectedLinkedItem) throws Throwable {
        String actualLinkedItem = useStoryPanelItem.getLinkedValue(expectedLinkedItem);
        Assert.assertEquals(expectedLinkedItem, actualLinkedItem);
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Create subtask' button in 'Edit' panel$")
    public void rcClickInCreateSubtaskButtonInEditPanel() throws InterruptedException {
        useStoryPanelItem.clickOnCreateSubTask();
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Subtasks' field in 'Edit' panel$")
    public void rcClickInSubtasksFieldInEditPanel() throws InterruptedException {
        useStoryPanelItem.clickSubTaskField();
        Thread.sleep(5000);
    }

    @And("^rc Fill item \"([^\"]*)\" in 'Subtasks' field in 'Edit' dialog$")
    public void rcFillItemInSubtasksFieldInEditDialog(String subtask) throws Throwable {
        useStoryPanelItem.fillSubTaskField(subtask);
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Create' button in 'Subtasks' field in 'Edit' dialog$")
    public void rcClickInCreateButtonInSubtasksFieldInEditDialog() throws InterruptedException {
        useStoryPanelItem.clickOnCreateSubTaskButton();
        Thread.sleep(5000);
    }

    @Then("^rc Verify \"([^\"]*)\" subtask field is set in 'Edit' page$")
    public void rcVerifySubtaskFieldIsSetInEditPage(String expectedSubtask) throws Throwable {
        String actualSubtask = useStoryPanelItem.getSubTaskValue(expectedSubtask);
        Assert.assertEquals(expectedSubtask, actualSubtask);
        Thread.sleep(5000);
    }
}
