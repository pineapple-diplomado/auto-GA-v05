package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.Tasks.*;
import org.umssdiplo.automationv01.core.Tasks.TasksLoadPageJavierZapata;

public class TasksStepDefinitions {
    private Login login;
    private TasksJiraLoginPage tasksJiraLoginPage;
    private TasksHomePage tasksHomePage;
    private TasksBackLogPage tasksBackLogPage;
    private TasksCreationTaskDialog tasksCreationTaskDialog;
    private TasksPanelConfiguracionTask tasksPanelConfiguracionTask;


    @Given("^'JiraLoginPage' page is loaded$")
    public void jirapagePageIsLoaded() {
        //tasksJiraLoginPage = TasksLoadPageJavierZapata.homePage();
        tasksBackLogPage = TasksLoadPageJavierZapata.homePage2();
    }

    @And("^jz set my credentials on 'JiraLoginPage' page$")
    public void setMyCredentialsOnAtlassianPage() {
        //tasksHomePage = tasksJiraLoginPage.setCredentials();
        tasksBackLogPage = tasksJiraLoginPage.setCredentials();
    }

    @And("^jz Click \"([^\"]*)\" proyecto on HomePage page$")
    public void clickProyectoOnHomePagePage(String nombreProyecto) throws Throwable {
        tasksBackLogPage = tasksHomePage.seleccionarProyecto(nombreProyecto);
    }

    @And("^jz Click \"([^\"]*)\" boton on BackLog page$")
    public void clickBotonOnBackLogPage(String nombreBoton) throws Throwable {
        tasksBackLogPage.dialogoCrearTask(nombreBoton);
    }

    @And("^jz Click OpenCreateDialog boton on BackLog page$")
    public void clickOpenCreateDialogBotonOnBackLogPage() {
        tasksCreationTaskDialog = tasksBackLogPage.dialogoCrearTask2();
    }

    @And("^jz Select 'Task' option on CreationTaskDialog dialog$")
    public void selectTaskOptionOnCreationTaskDialogDialog() {
        tasksCreationTaskDialog.createIssue();
    }

    @And("^jz Insert \"([^\"]*)\" input on CreationTaskDialog dialog$")
    public void insertInputOnCreationTaskDialogDialog(String titulo){
        tasksCreationTaskDialog.insertSummary(titulo);
    }

    @And("^jz Click 'Create' button on CreationTaskDialog dialog$")
    public void clickCreateButtonOnCreationTaskDialogDialog() {
        tasksCreationTaskDialog.presionarCreateButton();
    }

    @Then("^jz Check \"([^\"]*)\" in List on BackLog page$")
    public void checkInListOnBackLogPage(String nombreTask) {
        boolean res = tasksBackLogPage.checkExistenciaDeUltimoTask(nombreTask);
        Assert.assertEquals(res,true);
    }

    @And("^jz Select \"([^\"]*)\" task on BackLog page$")
    public void selectTaskOnBackLogPage(String tituloTask) {
        tasksPanelConfiguracionTask = tasksBackLogPage.clickEnUnTask(tituloTask);
    }

    @And("^jz Select 'InProgress' in status on PanelConfigurationTask page$")
    public void selectInProgressInStatusOnPanelConfigurationTaskPage() {
        tasksPanelConfiguracionTask.setSelectInProgress();
    }

    @And("^jz Check 'InProgrees' in status on PanelConfigurationTask page$")
    public void checkInProgreesInStatusOnPanelConfigurationTaskPage() {
        String status = tasksPanelConfiguracionTask.verificandoInProgress();
        Assert.assertEquals(status,"In Progress");
    }

    @And("^jz Click 'Create sub task' icon on PanelConfigurationTask page$")
    public void clickCreateSubTaskIconOnPanelConfigurationTaskPage() {
        tasksPanelConfiguracionTask.clickCreacionSubTask();
    }

    @Then("^jz Check 'Subtareas' label displayed on PanelConfigurationTask page$")
    public void checkSubtareasLabelDisplayedOnPanelConfigurationTaskPage() {
        tasksPanelConfiguracionTask.checkSubTareasDisplayedFormulario();
    }

    @And("^jz Insert \"([^\"]*)\" field subTask on PanelConfigurationTask page$")
    public void insertFieldSubTaskOnPanelConfigurationTaskPage(String nombreSubTask) {
        tasksPanelConfiguracionTask.insertarSubTask(nombreSubTask);
    }

    @And("^jz Click 'Crear' button on PanelConfigurationTask page$")
    public void clickCrearButtonOnPanelConfigurationTaskPage() {
        tasksPanelConfiguracionTask.clickBotonCrearSubTask();
    }

    @Then("^jz Check \"([^\"]*)\" field subTask on PanelConfigurationTask page$")
    public void checkFieldSubTaskOnPanelConfigurationTaskPage(String subTask){
        tasksPanelConfiguracionTask.checkSubTareaSaved(subTask);
    }

    @Then("^jz Click 'Close' icon on PanelConfigurationTask page$")
    public void clickCloseIconOnPanelConfigurationTaskPage() {
        tasksPanelConfiguracionTask.cerrarPanelConfiguration();
    }


    @And("^jz Click 'Only my issues' button with user \"([^\"]*)\" on BackLog page$")
    public void clickOnlyMyIssuesButtonWithUserOnBackLogPage(String user) {
        int numeroEnBackLog = tasksBackLogPage.checkIssuesNumberUser(user);  //verifica q issues en backlog de un user sean vistos en Only my issues
        int numeroEnOnlyMyIssues = tasksBackLogPage.checkIssuesNumberUserOnlyMyIssues(user);
        Assert.assertEquals(numeroEnBackLog,numeroEnOnlyMyIssues);  //tiene q ser el mismo numero
    }

    @And("^jz Click \"([^\"]*)\" on comment on PanelConfigurationTask page$")
    public void selectCommentOnPanelConfigurationTaskPage(String comentario) throws Throwable {
        tasksPanelConfiguracionTask.borrarComentario(comentario);
    }


    @Then("^jz Add \"([^\"]*)\" in comment on PanelConfigurationTask page$")
    public void addInCommentOnPanelConfigurationTaskPage(String nuevoComentario) throws Throwable {
        tasksPanelConfiguracionTask.anadirNuevoComentario(nuevoComentario);
    }

    @And("^jz 'Backlog' page is loaded$")
    public void jzBacklogPageIsLoaded() {
        tasksBackLogPage = TasksLoadPageJavierZapata.loadBackLog();
    }
}
