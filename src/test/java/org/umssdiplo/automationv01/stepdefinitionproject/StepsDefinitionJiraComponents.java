package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.managepage.components.Components;
import org.umssdiplo.automationv01.core.managepage.dialog.CreateComponentDialog;
import org.umssdiplo.automationv01.core.managepage.dialog.EditComponentDialog;
import org.umssdiplo.automationv01.core.managepage.projectPage.ProjectPage;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionJiraComponents {
    private Components components;
    private ProjectPage projectPage;
    private Login login;
    private CreateComponentDialog createComponentDialog;
    private EditComponentDialog editComponentDialog;

    @And("^'click Component option' of the main menu$")
    public void clickComponentOptionOfTheMainMenu() {
        components = LoadPage.componentsPage();
         components.redirect();
    }

    @Given("^Jira page is loaded$")
    public void jiraPageIsLoaded() {
        login = LoadPage.loginPage();
    }

    @And("^User is logged in$")
    public void userIsLoggedIn()throws Throwable {
        projectPage = login.setAllCredentials() ;
    }

    @When("^click 'Components' option on 'Main page' of Jira$")
    public void clickComponentsOptionOnMainPageOfJira() {
        components.redirect();
    }

    @Then("^verify that the title of the page should be \"([^\"]*)\"$")
    public void verifyThatTheTitleOfThePageShouldBe(String expectedTitle) throws Throwable {
        String currentTitle = components.getTitle();
        Assert.assertEquals(currentTitle, expectedTitle);
    }

    @And("^click 'Create Component' button on 'Components page'$")
    public void clickCreateComponentButtonOnComponentsPage() {
        createComponentDialog = components.clickCreateComponentButton();
    }

    @And("^set the name field with \"([^\"]*)\" on 'CreateComponentDialog'$")
    public void setTheNameFieldWithOnCreateComponentDialog(String componentName) throws Throwable {
        createComponentDialog.setComponentName(componentName);
    }

    @And("^set the description field with \"([^\"]*)\" on 'CreateComponentDialog'$")
    public void setTheDescriptionFieldWithOnCreateComponentDialog(String componentDescription) throws Throwable {
        createComponentDialog.setComponentDescription(componentDescription);
    }

    @And("^set the component lead field with \"([^\"]*)\" on 'CreateComponentDialog'$")
    public void setTheComponentLeadFieldWithOnCreateComponentDialog(String componentLead) throws Throwable {
        createComponentDialog.setComponentLead(componentLead);
    }

    @And("^set the default lead field with \"([^\"]*)\" on 'CreateComponentDialog'$")
    public void setTheDefaultLeadFieldWithOnCreateComponentDialog(String assignee) throws Throwable {
        createComponentDialog.setDefaultAssignee(assignee);
    }

    @When("^click 'Save' button on 'CreateComponentDialog'$")
    public void clickSaveButtonOnCreateComponentDialog() {
        createComponentDialog.clickSaveButton();
    }

    @Then("^verifying created \"([^\"]*)\"component on 'Component page'$")
    public void verifyingCreatedComponentOnComponentPage(String componentName) throws Throwable {
//        Boolean isCreated = createComponentDialog.verifyCreation(componentName);
        Assert.assertTrue(createComponentDialog.verifyCreation(componentName));
    }

    @And("^click outside of 'CreateComponentDialog'$")
    public void clickOutsideOfCreateComponentDialog() {
        createComponentDialog.clickOutSideForm();
    }

    @And("^delete the component called \"([^\"]*)\" on 'Component page'$")
    public void deleteTheComponentCalledOnComponentPage(String componentName) throws Throwable {
//        components.deleteComponent(componentName);
    }

    @And("^delete the last component created on 'Component page'$")
    public void deleteTheLastComponentCreatedOnComponentPage() {
        components.deleteComponent();
    }

    @Then("^verify the \"([^\"]*)\" was deleted on 'Component page'$")
    public void verifyTheWasDeletedOnComponentPage(String componentName) throws Throwable {
        Assert.assertTrue(components.verifyDeletedComponent(componentName));
    }

    @And("^edit the last component created on 'Component page'$")
    public void editTheLastComponentCreatedOnComponentPage() {
        editComponentDialog = components.openEditComponentDialog();
    }

    @And("^delete the name on 'Edit component dialog'$")
    public void deleteTheNameOnEditComponentDialog() {
        editComponentDialog.deleteNameComponent();
    }

    @Then("^verify that the 'Save' button should be disable on 'Edit component dialog'$")
    public void verifyThatTheSaveButtonShouldBeDisableOnEditComponentDialog() {
        Assert.assertTrue(editComponentDialog.isSaveButtonDisabled());
    }

    @And("^set the description field with \"([^\"]*)\" on 'Edit component dialog'$")
    public void setTheDescriptionFieldWithOnEditComponentDialog(String newDescription) throws Throwable {
        editComponentDialog.setDescriptionField(newDescription);
    }

    @And("^set the default lead field with \"([^\"]*)\" on 'Edit component dialog'$")
    public void setTheDefaultLeadFieldWithOnEditComponentDialog(String selectedAssignee) throws Throwable {
        editComponentDialog.editDefaultAssignee(selectedAssignee);
    }

    @When("^click 'Save' button on 'Edit component dialog'$")
    public void clickSaveButtonOnEditComponentDialog() {
        components = editComponentDialog.updateComponent();
    }

    @Then("^verify that description should be \"([^\"]*)\" on 'Component page'$")
    public void verifyThatDescriptionShouldBeOnComponentPage(String expectedDescription) throws Throwable {
        String currentDescription = components.getDescription();
        Assert.assertEquals(currentDescription, expectedDescription);
    }

    @And("^find \"([^\"]*)\" on 'Components page'$")
    public void findOnComponentsPage(String component) throws Throwable {
        components.findComponent(component);
    }

    @Then("^verify that 'Component page' should show \"([^\"]*)\" component$")
    public void verifyThatComponentPageShouldShowComponent(String component) throws Throwable {
        Assert.assertTrue(components.isCurrent(component));
    }


    @Then("^verify that 'Cancel' button should be disabled on 'CreateComponentDialog'$")
    public void verifyThatCancelButtonShouldBeDisabledOnCreateComponentDialog() {
        Assert.assertTrue(createComponentDialog.isCancelButtonEnable());
    }

    @Given("^Jira page \"([^\"]*)\" is loaded$")
    public void jiraPageIsLoaded(String jiraUrl) throws Throwable {
        login = LoadPage.loginJiraPage(jiraUrl);
    }

    @And("^set \"([^\"]*)\" email on 'Login' page$")
    public void setEmailOnLoginPage(String email) throws Throwable {
        login.setEmail(email);
    }

    @And("^select the project on 'Project page'$")
    public void selectTheProjectOnProjectPage() {
        components = projectPage.openProject();
    }
}
