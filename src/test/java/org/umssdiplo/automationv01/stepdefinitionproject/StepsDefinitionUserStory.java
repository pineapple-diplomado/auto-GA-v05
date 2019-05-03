package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.managepage.page.*;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionUserStory {
    private Login login;
    private Backlog backlog;
    private BrowseProjects browseProjects;
    private StoryCreationMenu storyCreationMenu;
    DialogItemCreation dialogItemCreation;
    PanelItem panelItem;

    @Given("^Main page \"([^\"]*)\" is open$")
    public void mainPageIsOpen(String url) throws Throwable {
        login = LoadPage.loginPage(url);
    }

    @And("^Set username \"([^\"]*)\" in 'Login' page$")
    public void setUsernameInLoginPage(String email) throws Throwable {
        login.setEmail(email);
    }

    @And("^Set password \"([^\"]*)\" in 'Login' page$")
    public void setPasswordInLoginPage(String password) throws Throwable {
        browseProjects = login.setPassword(password);
    }

    @And("^rc Click on \"([^\"]*)\" in 'Browse Projects' page$")
    public void rcClickOnInBrowseProjectsPage(String project) throws Throwable {
        backlog = browseProjects.clickProjectLink(project);
    }

    @And("^Open Proyecto page$")
    public void openProyectoPage() {
        backlog = browseProjects.openBacklogProject1();
    }

    @And("^rc Click on 'Create issue' button in 'Backlog' page$")
    public void rcClickOnCreateIssueButtonInBacklogPage() {
        dialogItemCreation = backlog.clickCreateIssueBtn();
    }

    @And("^rc Fill \"([^\"]*)\" in 'Create' dialog$")
    public void rcFillInCreateDialog(String summary) throws Throwable {
        dialogItemCreation.fillText(summary);
    }

    @And("^rc Click on 'Create' button in 'Create' dialog$")
    public void rcClickOnCreateButtonInCreateDialog() throws InterruptedException {
        dialogItemCreation.clickCreateDialogButton();
        Thread.sleep(5000);
    }

    @Then("^rc Verify \"([^\"]*)\" is created in 'Backlog' page$")
    public void verifyIsCreatedInBacklogPage(String expectedStoryName) throws Throwable {
        Thread.sleep(5000);
        String actualStoryName = backlog.getFirstStory();

        Assert.assertEquals(actualStoryName, expectedStoryName);
    }

    @And("^rc Click on \"([^\"]*)\" in 'Backlog' page$")
    public void rcClickOnInBacklogPage(String storyName) throws Throwable {
        panelItem = backlog.clicOnItem(storyName);
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Status' in 'Edit' panel$")
    public void rcClickInStatusInEditPanel() throws InterruptedException {
        panelItem.clickOnStatus();
        Thread.sleep(5000);
    }

    @And("^rc Click in 'In Progress' in 'Edit' panel$")
    public void rcClickInInProgressInEditPanel() {
        panelItem.clickOnStatusInProgress();
    }

    @And("^rc Click in 'Description' in 'Edit' panel$")
    public void rcClickInDescriptionInEditPanel() throws InterruptedException {
        panelItem.clickOnDescription();
        Thread.sleep(5000);
    }

    @And("^rc Fill \"([^\"]*)\" in description field in 'Edit' panel$")
    public void rcFillInDescriptionFieldInEditPanel(String text) throws Throwable {
        panelItem.fillOnDescription(text);
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Save' in 'Edit' panel$")
    public void rcClickInSaveInEditPanel() {
        panelItem.clickOnSaveDescription();
    }

    @And("^rc Click in 'Comment' in 'Edit' panel$")
    public void rcClickInCommentInEditPanel() throws InterruptedException {
        panelItem.clickOnComment();
        Thread.sleep(5000);
    }

    @And("^rc Fill \"([^\"]*)\" in comment field in 'Edit' panel$")
    public void rcFillInCommentFieldInEditPanel(String text) throws Throwable {
        panelItem.fillOnComment(text);
        Thread.sleep(5000);
    }

    @And("^rc Click in comment 'Save' in 'Edit' panel$")
    public void rcClickInCommentSaveInEditPanel() {
        panelItem.clickOnSaveComment();
    }

    @And("^rc Click in 'Show more' button in 'Edit' panel$")
    public void rcClickInShowMoreButtonInEditPanel() throws InterruptedException {
        panelItem.clickOnShowMore();
        Thread.sleep(5000);
        panelItem.clickOnShowMore();
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Time Tracking' field in 'Edit' panel$")
    public void rcClickInTimeTrackingFieldInEditPanel() throws InterruptedException {
        panelItem.clickOnTimeLogged();
        Thread.sleep(5000);
    }

    @And("^rc Fill \"([^\"]*)\" in time logged field in 'Time Tracking' dialog$")
    public void rcFillInTimeLoggedFieldInTimeTrackingDialog(String text) throws Throwable {
        panelItem.fillTimeLogged(text);
        Thread.sleep(5000);
    }

    @And("^rc Click 'Save' in 'Time Tracking' dialog$")
    public void rcClickSaveInTimeTrackingDialog() {
        panelItem.clickOnSaveTimeLogged();
    }

    @And("^rc Click in 'Link' button in 'Edit' panel$")
    public void rcClickInLinkButtonInEditPanel() throws InterruptedException {
        panelItem.clickOnLinkButton();
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Search for issues' field in 'Edit' panel$")
    public void rcClickInSearchForIssuesFieldInEditPanel() throws InterruptedException {
        panelItem.clickOnSearchIssues();
        Thread.sleep(5000);
    }

    @And("^rc Click 'Link' button in 'Linked issues' panel$")
    public void rcClickLinkButtonInLinkedIssuesPanel() {
        panelItem.clickOnSaveLink();
    }

    @And("^rc Fill item \"([^\"]*)\" in active issues in 'Edit' dialog$")
    public void rcFillItemInActiveIssuesInEditDialog(String item) throws Throwable {
        String textItem = panelItem.getTextSelectedItem(item);
        Thread.sleep(5000);
        panelItem.fillLinkItem(textItem);
        Thread.sleep(5000);
    }

    @And("^rc Click enter on item in active issues in 'Edit' dialog$")
    public void rcClickEnterOnItemInActiveIssuesInEditDialog() throws InterruptedException {
        panelItem.clickEnterLinkItem();
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Create subtask' button in 'Edit' panel$")
    public void rcClickInCreateSubtaskButtonInEditPanel() throws InterruptedException {
        panelItem.clickOnCreateSubTask();
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Subtasks' field in 'Edit' panel$")
    public void rcClickInSubtasksFieldInEditPanel() throws InterruptedException {
        panelItem.clickSubTaskField();
        Thread.sleep(5000);
    }

    @And("^rc Fill item \"([^\"]*)\" in 'Subtasks' field in 'Edit' dialog$")
    public void rcFillItemInSubtasksFieldInEditDialog(String subtask) throws Throwable {
        panelItem.fillSubTaskField(subtask);
        Thread.sleep(5000);
    }

    @And("^rc Click in 'Create' button in 'Subtasks' field in 'Edit' dialog$")
    public void rcClickInCreateButtonInSubtasksFieldInEditDialog() throws InterruptedException {
        panelItem.clickOnCreateSubTaskButton();
        Thread.sleep(5000);
    }
}
