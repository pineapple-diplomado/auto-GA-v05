package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.managepage.page.Backlog;
import org.umssdiplo.automationv01.core.managepage.page.BrowseProjects;
import org.umssdiplo.automationv01.core.managepage.page.DialogItemCreation;
import org.umssdiplo.automationv01.core.managepage.page.StoryCreationMenu;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionUserStory {
    private Login login;
    private Backlog backlog;
    private BrowseProjects browseProjects;
    private StoryCreationMenu storyCreationMenu;
    DialogItemCreation dialogItemCreation;

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
    public void rcClickOnCreateButtonInCreateDialog() {
        dialogItemCreation.clickCreateDialogButton();
    }
}
