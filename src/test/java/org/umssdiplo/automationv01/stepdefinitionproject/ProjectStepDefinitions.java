package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.projects.ProjectCommon;
import org.umssdiplo.automationv01.core.projects.ProjectLoadPage;
import org.umssdiplo.automationv01.core.projects.ProjectLogin;
import org.umssdiplo.automationv01.core.projects.ProjectManagement;

public class ProjectStepDefinitions {
    private ProjectLogin login;
    private ProjectManagement projectManagement;

    @Given("^PRJ Jira page is loaded$")
    public void scaPageIsLoaded() throws Throwable {
        this.login = ProjectLoadPage.loginPage();
        this.projectManagement = new ProjectManagement();
    }

    @And("^PRJ User is logged in$")
    public void userIsLoggedIn() throws Throwable {
        this.login.login();
    }

    @Given("^PRJ Click en dropdown \"([^\"]*)\" localizado el la parte de arriba a la derecha de la pagina$")
    public void clickOnDropDownInTopRightSide(String createProjectButton) throws Throwable {
        this.projectManagement.clickCreateProject(createProjectButton);
    }

    @Given("^PRJ Click en el link \"([^\"]*)\" del menu lateral izquierdo$")
    public void clickMenuItem(String menuItem) throws Throwable {
        this.projectManagement.clickMenuItem(menuItem);
    }

    @And("^PRJ Seleccionar el drop down item \"([^\"]*)\"$")
    public void seleccionarElDropDownItem(String dropdownItemName) throws Throwable {
        this.projectManagement.seleccionarElDropDownItem(dropdownItemName);
    }

    @And("^PRJ Click en el boton \"([^\"]*)\" de la tarjeta con el nombre \"([^\"]*)\"$")
    public void clickEnElBotonDeLaTarjetaConElNombre(String buttonName, String template) throws Throwable {
        this.projectManagement.clickEnElBotonDeLaTarjetaConElNombre(buttonName, template);
    }

    @And("^PRJ Editar el campo \"([^\"]*)\" con el valor \"([^\"]*)\"$")
    public void editarElCampoConElValor(String fieldName, String fieldValue) throws Throwable {
        this.projectManagement.editarElCampoConElValor(fieldName, fieldValue);
    }

    @And("^PRJ Click en el boton \"([^\"]*)\"$")
    public void clickEnElBoton(String buttonName) throws Throwable {
        this.projectManagement.clickEnElBoton(buttonName);
    }

    @Then("^PRJ Se muestra la pagina del proyecto con el nombre \"([^\"]*)\" seleccionado en el menu lateral izquierdo$")
    public void seMuestraLaPaginaDelProyectoConElNombreSeleccionadoEnElMenuLateralIzquierdo(String projectName) throws Throwable {
        this.projectManagement.seMuestraLaPaginaDelProyectoConElNombreSeleccionadoEnElMenuLateralIzquierdo(projectName);
    }

    @Then("^PRJ El proyecto \"([^\"]*)\" debe estar en la lista de proyectos$")
    public void elProyectoDebeEstarEnLaListaDeProyectos(String projectName) throws Throwable {
        this.projectManagement.elProyectoDebeEstarEnLaListaDeProyectos(projectName);
    }

    @And("^PRJ Click en el dropdown \"([^\"]*)\" en la tabla de proyectos para el proyecto \"([^\"]*)\"$")
    public void clickEnElDropdownEnLaTablaDeProyectosParaElProyecto(String dropdownName, String projectName) throws Throwable {
        this.projectManagement.clickEnElDropdownEnLaTablaDeProyectosParaElProyecto(dropdownName, projectName);
    }

    @And("^PRJ Seleccionar el dropdown item \"([^\"]*)\"$")
    public void clickEnElDropdownItem(String dropdownItemName) throws Throwable {
        this.projectManagement.clickEnElDropdownItem(dropdownItemName);
    }

    @And("^PRJ Editar el campo \"([^\"]*)\" del proyecto creado y cambiarlo a \"([^\"]*)\"$")
    public void editarElCampoDelProyectoCreadoYCambiarloA(String oldFieldValue, String newFieldValue) throws Throwable {
        this.projectManagement.editarElCampoDelProyectoCreadoYCambiarloA(oldFieldValue, newFieldValue);
    }

    @And("^PRJ Editar el campo 'Description' del proyecto creado y cambiarlo a \"([^\"]*)\"$")
    public void editarElCampoDescriptionDelProyectoCreadoYCambiarloA(String newValue) throws Throwable {
        this.projectManagement.editarElCampoDescriptionDelProyectoCreadoYCambiarloA(newValue);
    }

    @And("^PRJ Click en el boton \"([^\"]*)\" ubicada en la parte inferior de la pagina$")
    public void clickEnElBotonUbicadaEnLaParteInferiorDeLaPagina(String buttonName) throws Throwable {
        this.projectManagement.clickEnElBotonUbicadaEnLaParteInferiorDeLaPagina(buttonName);
    }

    @And("^PRJ Click en el breadcrumb item \"([^\"]*)\"$")
    public void clickEnElBreadcrumbItem(String breadcrumbItemName) throws Throwable {
        this.projectManagement.clickEnElBreadcrumbItem(breadcrumbItemName);
    }

    @Then("^PRJ Verificar que el el campo \"([^\"]*)\" del proyecto \"([^\"]*)\" cambio a \"([^\"]*)\"$")
    public void verificarQueElElCampoDelProyectoCreadoCambioA(String fieldName, String projectName, String expected) throws Throwable {
        String actual = this.projectManagement.verificarQueElElCampoDelProyectoCreadoCambioA(fieldName, projectName);
        Assert.assertEquals(actual, expected);
    }

    @Then("^PRJ Verificar que el el campo \"([^\"]*)\" del proyecto \"([^\"]*)\" cambio a \"([^\"]*)\" in the project settings page$")
    public void verificarQueElElCampoDelProyectoCambioAInTheProjectSettingsPage(String fieldName, String projectName, String expected) throws Throwable {
        this.projectManagement.verificarQueElElCampoDelProyectoCambioAInTheProjectSettingsPage(fieldName, projectName, expected);
        Assert.assertTrue(true);
    }

    @And("^PRJ Click en el dropdown \"([^\"]*)\" and click en el dropdown item \"([^\"]*)\"$")
    public void selectDropdownAndItem(String dropdownName, String dropdownItemName) throws Throwable {
        this.projectManagement.selectDropdownAndItem(dropdownName, dropdownItemName);
    }

    @Then("^PRJ Verificar que el mensaje de error \"([^\"]*)\" es mostrado para el campo \"([^\"]*)\"$")
    public void verificarQueElMensajeDeErrorEsMostrado(String errorMessage, String fieldName) throws Throwable {
        this.projectManagement.verificarQueElMensajeDeErrorEsMostrado(errorMessage, fieldName);
        Assert.assertTrue(true);
    }
}
