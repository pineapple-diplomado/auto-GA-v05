package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.managepage.PagesJavierZapata.BackLogPage;
import org.umssdiplo.automationv01.core.managepage.PagesJavierZapata.CreationTaskDialog;
import org.umssdiplo.automationv01.core.managepage.PagesJavierZapata.HomePage;
import org.umssdiplo.automationv01.core.managepage.PagesJavierZapata.JiraLoginPage;
import org.umssdiplo.automationv01.core.utils.LoadPageJavierZapata;

import java.util.List;

public class StepsDefinitionJavierZapata {
    private Login login;
    private JiraLoginPage jiraLoginPage;
    private HomePage homePage;
    private BackLogPage backLogPage;
    private CreationTaskDialog creationTaskDialog;



    @Given("^'JiraLoginPage' page is loaded$")
    public void jirapagePageIsLoaded() {
        jiraLoginPage = LoadPageJavierZapata.homePage();

    }

    @And("^set my credentials on 'JiraLoginPage' page$")
    public void setMyCredentialsOnAtlassianPage() {
        homePage = jiraLoginPage.setCredentials();
    }

    @And("^Click \"([^\"]*)\" proyecto on HomePage page$")
    public void clickProyectoOnHomePagePage(String nombreProyecto) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        backLogPage = homePage.seleccionarProyecto(nombreProyecto);
    }

    @And("^Click \"([^\"]*)\" boton on BackLog page$")
    public void clickBotonOnBackLogPage(String nombreBoton) throws Throwable {
        backLogPage.dialogoCrearTask(nombreBoton);
    }

    @And("^Click OpenCreateDialog boton on BackLog page$")
    public void clickOpenCreateDialogBotonOnBackLogPage() {
        creationTaskDialog = backLogPage.dialogoCrearTask2();
    }

    @And("^Select 'Task' option on CreationTaskDialog dialog$")
    public void selectTaskOptionOnCreationTaskDialogDialog() {
        creationTaskDialog.createIssue();
    }

    @And("^Insert \"([^\"]*)\" input on CreationTaskDialog dialog$")
    public void insertInputOnCreationTaskDialogDialog(String titulo){
        creationTaskDialog.insertSummary(titulo);
    }

    @And("^Click 'Create' button on CreationTaskDialog dialog$")
    public void clickCreateButtonOnCreationTaskDialogDialog() {
        creationTaskDialog.presionarCreateButton();
    }

    @Then("^Check \"([^\"]*)\" in List on BackLog page$")
    public void checkInListOnBackLogPage(String nombreTask) {
        boolean res = backLogPage.checkExistenciaDeUltimoTask(nombreTask);
        Assert.assertEquals(res,true);

    }
}
