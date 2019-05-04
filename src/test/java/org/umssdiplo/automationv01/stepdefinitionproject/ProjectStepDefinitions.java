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

    @Given("^Jira page is loaded$")
    public void scaPageIsLoaded() throws Throwable {
        this.login = ProjectLoadPage.loginPage();
        this.projectManagement = new ProjectManagement();
    }

    @And("^User is logged in$")
    public void userIsLoggedIn() throws Throwable {
        this.login.login();
    }

    @Given("^PROJ: Click en drop down 'Create project' localizado el la parte de arriba a la derecha de la pagina$")
    public void clickOnCreateProject() throws Throwable {
        this.projectManagement.clickCreateProject();
    }

    @Given("^Click en el link \"([^\"]*)\" del menu lateral izquierdo$")
    public void clickMenuItem(String menuItem) throws Throwable {
        //By by = By.xpath("//a[@href='/secure/project/ViewProjects.jspa' and .//div[.='" + menuItem + "']]");
        By by = By.xpath("//a[@href='/secure/BrowseProjects.jspa' and .//div[.='" + menuItem + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @And("^Seleccionar el drop down item \"([^\"]*)\"$")
    public void seleccionarElDropDownItem(String dropdownItemName) throws Throwable {
        By by = By.xpath("//span[@role='menuitem' and .//div[contains(text(),'" + dropdownItemName + "')]]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @And("^Click en el boton \"([^\"]*)\" de la tarjeta con el nombre \"([^\"]*)\"$")
    public void clickEnElBotonDeLaTarjetaConElNombre(String buttonName, String template) throws Throwable {
        By by = By.xpath("//div[./div/h3[.='" + template +"']]//button[.//span[contains(text(),'" + buttonName + "')]]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @And("^Editar el campo \"([^\"]*)\" con el valor \"([^\"]*)\"$")
    public void editarElCampoConElValor(String fieldName, String fieldValue) throws Throwable {
        By by = By.xpath("//div[./label/div/span[.='" + fieldName + "']]//input[@type='text']");
        WebElement element = ProjectCommon.getElement(by);
        ProjectCommon.setInputField(element, fieldValue);
    }

    @And("^Click en el boton \"([^\"]*)\"$")
    public void clickEnElBoton(String buttonName) throws Throwable {
        By by = By.xpath("//button[.//span[.='" + buttonName + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickButton(by);
    }

    @Then("^Se muestra la pagina del proyecto con el nombre \"([^\"]*)\" seleccionado en el menu lateral izquierdo$")
    public void seMuestraLaPaginaDelProyectoConElNombreSeleccionadoEnElMenuLateralIzquierdo(String projectName) throws Throwable {
        By by = By.xpath("//div[.='" + projectName + "']/following-sibling::div[.='Software project']");
        ProjectCommon.isVisible(by);
    }

    @Then("^El proyecto \"([^\"]*)\" debe estar en la lista de proyectos$")
    public void elProyectoDebeEstarEnLaListaDeProyectos(String projectName) throws Throwable {
        By by = By.xpath("//td/div/a[.='" + projectName + "']");
        ProjectCommon.isVisible(by);
    }

    @And("^Click en el dropdown \"([^\"]*)\" en la tabla de proyectos para el proyecto \"([^\"]*)\"$")
    public void clickEnElDropdownEnLaTablaDeProyectosParaElProyecto(String dropdownName, String projectName) throws Throwable {
        By by = By.xpath("//td[./div/a[.='" + projectName + "']]/following-sibling::td//button[.//span[@aria-label='" + dropdownName + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @And("^Seleccionar el dropdown item \"([^\"]*)\"$")
    public void clickEnElDropdownItem(String dropdownItemName) throws Throwable {
        By by = By.xpath("//a[.//span[.='" + dropdownItemName + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @And("^Editar el campo \"([^\"]*)\" del proyecto creado y cambiarlo a \"([^\"]*)\"$")
    public void editarElCampoDelProyectoCreadoYCambiarloA(String oldFieldValue, String newFieldValue) throws Throwable {
        By by = By.xpath("//label[contains(text(), '" + oldFieldValue + "')]/following-sibling::input");
        ProjectCommon.isVisible(by);
        WebElement element = ProjectCommon.getElement(by);
        ProjectCommon.setInputField(element, newFieldValue);
    }

    @And("^Click en el boton \"([^\"]*)\" ubicada en la parte inferior de la pagina$")
    public void clickEnElBotonUbicadaEnLaParteInferiorDeLaPagina(String buttonName) throws Throwable {
        By by = By.xpath("//input[@id='project-edit-submit']");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @And("^Click en el breadcrumb item \"([^\"]*)\"$")
    public void clickEnElBreadcrumbItem(String breadcrumbItemName) throws Throwable {
        By by = By.xpath("//a[.//span[.='" + breadcrumbItemName + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @Then("^Verificar que el el campo 'Name' del proyecto creado cambio a \"([^\"]*)\"$")
    public void verificarQueElElCampoDelProyectoCreadoCambioA(String fieldName, String newProjectName) throws Throwable {
        By by = By.xpath("//td/div/a[.='" + newProjectName + "']");
        ProjectCommon.isVisible(by);
    }

    @Then("^Verificar que el el campo 'Key' del proyecto creado cambio a \"([^\"]*)\"$")
    public void verificarQueElElCampoKeyDelProyectoCreadoCambioA(String newKeyName) throws Throwable {
        By by = By.xpath("(//td[./div/a[.='PROJ:ProyectoClassicScrumModified1']]/following-sibling::td)[1]/div");
        WebElement element = ProjectCommon.getElement(by);
        String actual = element.getText();
        Assert.assertEquals(newKeyName, actual);
    }
}
