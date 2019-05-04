package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.managepage.PagesJavierZapata.*;
import org.umssdiplo.automationv01.core.utils.LoadPageJavierZapata;

import java.util.List;

public class StepsDefinitionJavierZapata {
    private Login login;
    private JiraLoginPage jiraLoginPage;
    private HomePage homePage;
    private BackLogPage backLogPage;
    private CreationTaskDialog creationTaskDialog;
    private PanelConfiguracionTask panelConfiguracionTask;


    @Given("^'JiraLoginPage' page is loaded$")
    public void jirapagePageIsLoaded() {
        jiraLoginPage = LoadPageJavierZapata.homePage();
    }

    @And("^jz set my credentials on 'JiraLoginPage' page$")
    public void setMyCredentialsOnAtlassianPage() {
        //homePage = jiraLoginPage.setCredentials();
        backLogPage = jiraLoginPage.setCredentials();
    }

    @And("^jz Click \"([^\"]*)\" proyecto on HomePage page$")
    public void clickProyectoOnHomePagePage(String nombreProyecto) throws Throwable {
        backLogPage = homePage.seleccionarProyecto(nombreProyecto);
    }

    @And("^jz Click \"([^\"]*)\" boton on BackLog page$")
    public void clickBotonOnBackLogPage(String nombreBoton) throws Throwable {
        backLogPage.dialogoCrearTask(nombreBoton);
    }

    @And("^jz Click OpenCreateDialog boton on BackLog page$")
    public void clickOpenCreateDialogBotonOnBackLogPage() {
        creationTaskDialog = backLogPage.dialogoCrearTask2();
    }

    @And("^jz Select 'Task' option on CreationTaskDialog dialog$")
    public void selectTaskOptionOnCreationTaskDialogDialog() {
        creationTaskDialog.createIssue();
    }

    @And("^jz Insert \"([^\"]*)\" input on CreationTaskDialog dialog$")
    public void insertInputOnCreationTaskDialogDialog(String titulo){
        creationTaskDialog.insertSummary(titulo);
    }

    @And("^jz Click 'Create' button on CreationTaskDialog dialog$")
    public void clickCreateButtonOnCreationTaskDialogDialog() {
        creationTaskDialog.presionarCreateButton();
    }

    @Then("^jz Check \"([^\"]*)\" in List on BackLog page$")
    public void checkInListOnBackLogPage(String nombreTask) {
        boolean res = backLogPage.checkExistenciaDeUltimoTask(nombreTask);
        Assert.assertEquals(res,true);
    }

    @And("^jz Select \"([^\"]*)\" task on BackLog page$")
    public void selectTaskOnBackLogPage(String tituloTask) {
        panelConfiguracionTask = backLogPage.clickEnUnTask(tituloTask);
    }

    @And("^jz Select 'InProgress' in status on PanelConfigurationTask page$")
    public void selectInProgressInStatusOnPanelConfigurationTaskPage() {
        panelConfiguracionTask.setSelectInProgress();
    }

    @And("^jz Check 'InProgrees' in status on PanelConfigurationTask page$")
    public void checkInProgreesInStatusOnPanelConfigurationTaskPage() {
        String status = panelConfiguracionTask.verificandoInProgress();
        Assert.assertEquals(status,"In Progress");
    }

    @And("^jz Click 'Create sub task' icon on PanelConfigurationTask page$")
    public void clickCreateSubTaskIconOnPanelConfigurationTaskPage() {
        panelConfiguracionTask.clickCreacionSubTask();
    }

    @Then("^jz Check 'Subtareas' label displayed on PanelConfigurationTask page$")
    public void checkSubtareasLabelDisplayedOnPanelConfigurationTaskPage() {
        panelConfiguracionTask.checkSubTareasDisplayedFormulario();
    }

    @And("^jz Insert \"([^\"]*)\" field subTask on PanelConfigurationTask page$")
    public void insertFieldSubTaskOnPanelConfigurationTaskPage(String nombreSubTask) {
        panelConfiguracionTask.insertarSubTask(nombreSubTask);
    }

    @And("^jz Click 'Crear' button on PanelConfigurationTask page$")
    public void clickCrearButtonOnPanelConfigurationTaskPage() {
        panelConfiguracionTask.clickBotonCrearSubTask();
    }

    @Then("^jz Check \"([^\"]*)\" field subTask on PanelConfigurationTask page$")
    public void checkFieldSubTaskOnPanelConfigurationTaskPage(String subTask){
        panelConfiguracionTask.checkSubTareaSaved(subTask);
    }

    @Then("^jz Click 'Close' icon on PanelConfigurationTask page$")
    public void clickCloseIconOnPanelConfigurationTaskPage() {
        panelConfiguracionTask.cerrarPanelConfiguration();
    }


    @And("^jz Click 'Only my issues' button with user \"([^\"]*)\" on BackLog page$")
    public void clickOnlyMyIssuesButtonWithUserOnBackLogPage(String user) {
        int numeroEnBackLog = backLogPage.checkIssuesNumberUser(user);  //verifica q issues en backlog de un user sean vistos en Only my issues
        int numeroEnOnlyMyIssues = backLogPage.checkIssuesNumberUserOnlyMyIssues(user);
        Assert.assertEquals(numeroEnBackLog,numeroEnOnlyMyIssues);  //tiene q ser el mismo numero
    }

    @And("^jz Click \"([^\"]*)\" on comment on PanelConfigurationTask page$")
    public void selectCommentOnPanelConfigurationTaskPage(String comentario) throws Throwable {
        panelConfiguracionTask.borrarComentario(comentario);
    }


    @Then("^jz Add \"([^\"]*)\" in comment on PanelConfigurationTask page$")
    public void addInCommentOnPanelConfigurationTaskPage(String nuevoComentario) throws Throwable {
        panelConfiguracionTask.anadirNuevoComentario(nuevoComentario);
    }
}
