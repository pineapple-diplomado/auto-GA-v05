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
        //By by = By.xpath("//a[@href='/secure/project/ViewProjects.jspa' and .//div[.='" + menuItem + "']]");
        By by = By.xpath("//a[@href='/secure/BrowseProjects.jspa' and .//div[.='" + menuItem + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @And("^PRJ Seleccionar el drop down item \"([^\"]*)\"$")
    public void seleccionarElDropDownItem(String dropdownItemName) throws Throwable {
        By by = By.xpath("//span[@role='menuitem' and .//div[contains(text(),'" + dropdownItemName + "')]]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @And("^PRJ Click en el boton \"([^\"]*)\" de la tarjeta con el nombre \"([^\"]*)\"$")
    public void clickEnElBotonDeLaTarjetaConElNombre(String buttonName, String template) throws Throwable {
        By by = By.xpath("//div[./div/h3[.='" + template +"']]//button[.//span[contains(text(),'" + buttonName + "')]]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @And("^PRJ Editar el campo \"([^\"]*)\" con el valor \"([^\"]*)\"$")
    public void editarElCampoConElValor(String fieldName, String fieldValue) throws Throwable {
        By by = By.xpath("//div[./label/div/span[.='" + fieldName + "']]//input[@type='text']");
        WebElement element = ProjectCommon.getElement(by);
        ProjectCommon.setInputField(element, fieldValue);
    }

    @And("^PRJ Click en el boton \"([^\"]*)\"$")
    public void clickEnElBoton(String buttonName) throws Throwable {
        By by = By.xpath("//button[.//span[.='" + buttonName + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickButton(by);
    }

    @Then("^PRJ Se muestra la pagina del proyecto con el nombre \"([^\"]*)\" seleccionado en el menu lateral izquierdo$")
    public void seMuestraLaPaginaDelProyectoConElNombreSeleccionadoEnElMenuLateralIzquierdo(String projectName) throws Throwable {
        By by = By.xpath("//div[.='" + projectName + "']/following-sibling::div[.='Software project']");
        ProjectCommon.isVisible(by);
    }

    @Then("^PRJ El proyecto \"([^\"]*)\" debe estar en la lista de proyectos$")
    public void elProyectoDebeEstarEnLaListaDeProyectos(String projectName) throws Throwable {
        By by = By.xpath("//td/div/a[.='" + projectName + "']");
        ProjectCommon.isVisible(by);
    }

    @And("^PRJ Click en el dropdown \"([^\"]*)\" en la tabla de proyectos para el proyecto \"([^\"]*)\"$")
    public void clickEnElDropdownEnLaTablaDeProyectosParaElProyecto(String dropdownName, String projectName) throws Throwable {
        By by = By.xpath("//td[./div/a[.='" + projectName + "']]/following-sibling::td//button[.//span[@aria-label='" + dropdownName + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @And("^PRJ Seleccionar el dropdown item \"([^\"]*)\"$")
    public void clickEnElDropdownItem(String dropdownItemName) throws Throwable {
        By by = By.xpath("//a[.//span[.='" + dropdownItemName + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @And("^PRJ Editar el campo \"([^\"]*)\" del proyecto creado y cambiarlo a \"([^\"]*)\"$")
    public void editarElCampoDelProyectoCreadoYCambiarloA(String oldFieldValue, String newFieldValue) throws Throwable {
        By by = By.xpath("//label[contains(text(), '" + oldFieldValue + "')]/following-sibling::input");
        ProjectCommon.isVisible(by);
        WebElement element = ProjectCommon.getElement(by);
        ProjectCommon.setInputField(element, newFieldValue);
    }

    @And("^PRJ Editar el campo 'Description' del proyecto creado y cambiarlo a \"([^\"]*)\"$")
    public void editarElCampoDescriptionDelProyectoCreadoYCambiarloA(String newValue) throws Throwable {
        By by = By.xpath("//div[./label[contains(text(), 'Description')]]//textarea");
        ProjectCommon.isVisible(by);
        WebElement element = ProjectCommon.getElement(by);
        ProjectCommon.setInputField(element, newValue);
    }

    @And("^PRJ Click en el boton \"([^\"]*)\" ubicada en la parte inferior de la pagina$")
    public void clickEnElBotonUbicadaEnLaParteInferiorDeLaPagina(String buttonName) throws Throwable {
        By by = By.xpath("//input[@id='project-edit-submit']");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @And("^PRJ Click en el breadcrumb item \"([^\"]*)\"$")
    public void clickEnElBreadcrumbItem(String breadcrumbItemName) throws Throwable {
        By by = By.xpath("//a[.//span[.='" + breadcrumbItemName + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    @Then("^PRJ Verificar que el el campo \"([^\"]*)\" del proyecto \"([^\"]*)\" cambio a \"([^\"]*)\"$")
    public void verificarQueElElCampoDelProyectoCreadoCambioA(String fieldName, String projectName, String expected) throws Throwable {
        By by = By.xpath(
                "(//tr[./td/div/a[.='" + projectName +"']]/td)" +
                "[count(//th[./span/span[.='" + fieldName + "']]/preceding-sibling::*)+1]//text()[last()]/parent::*");
        ProjectCommon.isVisible(by);
        String actual = ProjectCommon.getTextContent(by);
        Assert.assertEquals(actual, expected);
    }

    @Then("^PRJ Verificar que el el campo \"([^\"]*)\" del proyecto \"([^\"]*)\" cambio a \"([^\"]*)\" in the project settings page$")
    public void verificarQueElElCampoDelProyectoCambioAInTheProjectSettingsPage(String fieldName, String projectName, String expected) throws Throwable {
        By by = By.xpath("//div[./label[contains(text(), '" + fieldName +"')]]//*[contains(text(), '" + expected + "')]");
        ProjectCommon.isVisible(by);
        Assert.assertTrue(true);
    }

    @And("^PRJ Click en el dropdown \"([^\"]*)\" and click en el dropdown item \"([^\"]*)\"$")
    public void selectDropdownAndItem(String dropdownName, String dropdownItemName) throws Throwable {
        By byDropDown = By.xpath("//div[./label[contains(text(), '" + dropdownName + "')]]/select");
        By byDropDownItem = By.xpath("//div[./label[contains(text(), '" + dropdownName + "')]]/select/option[contains(text(),'" + dropdownItemName + "')]");
        ProjectCommon.isVisible(byDropDown);
        ProjectCommon.clickElement(byDropDown);
        ProjectCommon.isVisible(byDropDownItem);
        ProjectCommon.clickElement(byDropDownItem);
    }

    @Then("^PRJ Verificar que el mensaje de error \"([^\"]*)\" es mostrado para el campo \"([^\"]*)\"$")
    public void verificarQueElMensajeDeErrorEsMostrado(String errorMessage, String fieldName) throws Throwable {
        By by = By.xpath("//div[@class='error' and contains(text(), '" + errorMessage + "')]");
        ProjectCommon.elementTobeClickable(by);
        Assert.assertTrue(true);
    }
}
