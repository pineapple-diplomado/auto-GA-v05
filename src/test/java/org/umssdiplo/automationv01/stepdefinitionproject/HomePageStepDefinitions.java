package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.ProjectManagement;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class HomePageStepDefinitions {
    private Login login;
    private ProjectManagement projectManagement;

    @Given("^Jira page is loaded$")
    public void scaPageIsLoaded() throws Throwable {
        this.login = LoadPage.loginPage();
    }

    @Given("^User is logged in$")
    public void userIsLoggedIn() throws Throwable {
        this.login.login();
    }

    @And("^click 'Create project' dropdown in 'Body'$")
    public void clickOnAccidentes() throws Throwable {
        //this.projectManagement = this.projectManagement.clickCreateProject();
    }

    @And("^fill \"([^\"]*)\" in Nombre field in 'Accident' form$")
    public void FillNombreAccidentField(String nombre) throws Throwable {
        this.projectManagement.setNombreField(nombre);
    }

    @And("^fill \"([^\"]*)\" in Descripcion field in 'Accident' form$")
    public void FillDescripcionAccidentField(String descripcion) throws Throwable {
        this.projectManagement.setDescripcionField(descripcion);
    }

    @And("^fill \"([^\"]*)\" in Tipo field in 'Accident' form$")
    public void FillTipoAccidentField(String tipo) throws Throwable {
        this.projectManagement.setTipoField(tipo);
    }

    @And("^fill \"([^\"]*)\" in Severidad field in 'Accident' form$")
    public void FillSeveridadAccidentField(String severidad) throws Throwable {
        this.projectManagement.setSeveridadField(severidad);
    }

    @Then("^fill 'Editar Accidente' fields in 'Accident' form")
    public void FillEditarAccidentFields() throws Throwable {
        this.projectManagement.setEditarAccidentFields();
    }

    @And("click 'GuardarAccidente' button in 'Accident' form")
    public void GuardarAccidentFields() throws Throwable {
        this.projectManagement.clickGuardarAccidente();
    }

    @And("click 'EditarAccidente' button in 'Accident' form")
    public void EditarAccidentFields() throws Throwable {
        this.projectManagement.clickEditarAccidente();
    }

    @And("click 'BorrarAccidente' button in 'Accident' form")
    public void BorrarAccidentFields() throws Throwable {
        this.projectManagement.clickBorrarAccidente();
    }

    @Then("^verify 'created accident' has been saved in 'Accidents' table$")
    public void verifyAccidentHasBeenCreatedInAccidentsListTable() {
        boolean isCreatedAccident = this.projectManagement.isAccidentCreated();
        Assert.assertEquals(isCreatedAccident, true);
    }

    @Then("^verify 'edited accident' has been saved in 'Accidents' table$")
    public void verifyAccidentHasBeenEditedInAccidentsListTable() {
        boolean isAccidentEdited = this.projectManagement.isAccidentEdited();
        Assert.assertEquals(isAccidentEdited, true);
    }

    @Then("^verify 'accident' has been deleted in 'Accidents' table$")
    public void verifyAccidentHasBeenDeletedInAccidentsListTable() {
        boolean isAccidentDeleted = this.projectManagement.isAccidentDeleted();
        Assert.assertEquals(isAccidentDeleted, true);
    }

}
