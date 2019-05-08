package org.umssdiplo.automationv01.core.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import javax.xml.xpath.XPath;

public class ProjectManagement extends BasePage {
    public ProjectManagement() {
    }

    public void clickCreateProject(String createProjectButton) {
        ProjectCommon.waitFor(3000);
        By by = By.xpath("//button[./span/span[.='" + createProjectButton + "']]");
        ProjectCommon.clickButton(by);
    }

    public void clickMenuItem(String menuItem) throws Throwable {
        By by = By.xpath("//a[@href='/secure/BrowseProjects.jspa' and .//div[.='" + menuItem + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    public void seleccionarElDropDownItem(String dropdownItemName) throws Throwable {
        By by = By.xpath("//span[@role='menuitem' and .//div[contains(text(),'" + dropdownItemName + "')]]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    public void clickEnElBotonDeLaTarjetaConElNombre(String buttonName, String template) throws Throwable {
        By by = By.xpath("//div[./div/h3[.='" + template +"']]//button[.//span[contains(text(),'" + buttonName + "')]]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    public void editarElCampoConElValor(String fieldName, String fieldValue) throws Throwable {
        By by = By.xpath("//div[./label/div/span[.='" + fieldName + "']]//input[@type='text']");
        WebElement element = ProjectCommon.getElement(by);
        ProjectCommon.setInputField(element, fieldValue);
    }

    public void clickEnElBoton(String buttonName) throws Throwable {
        By by = By.xpath("//button[.//span[.='" + buttonName + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickButton(by);
    }

    public void seMuestraLaPaginaDelProyectoConElNombreSeleccionadoEnElMenuLateralIzquierdo(String projectName) throws Throwable {
        By by = By.xpath("//div[.='" + projectName + "']/following-sibling::div[.='Software project']");
        ProjectCommon.isVisible(by);
    }

    public void elProyectoDebeEstarEnLaListaDeProyectos(String projectName) throws Throwable {
        By by = By.xpath("//td/div/a[.='" + projectName + "']");
        ProjectCommon.isVisible(by);
    }

    public void clickEnElDropdownEnLaTablaDeProyectosParaElProyecto(String dropdownName, String projectName) throws Throwable {
        By by = By.xpath("//td[./div/a[.='" + projectName + "']]/following-sibling::td//button[.//span[@aria-label='" + dropdownName + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    public void clickEnElDropdownItem(String dropdownItemName) throws Throwable {
        By by = By.xpath("//a[.//span[.='" + dropdownItemName + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    public void editarElCampoDelProyectoCreadoYCambiarloA(String oldFieldValue, String newFieldValue) throws Throwable {
        By by = By.xpath("//label[contains(text(), '" + oldFieldValue + "')]/following-sibling::input");
        ProjectCommon.isVisible(by);
        WebElement element = ProjectCommon.getElement(by);
        ProjectCommon.setInputField(element, newFieldValue);
    }

    public void editarElCampoDescriptionDelProyectoCreadoYCambiarloA(String newValue) throws Throwable {
        By by = By.xpath("//div[./label[contains(text(), 'Description')]]//textarea");
        ProjectCommon.isVisible(by);
        WebElement element = ProjectCommon.getElement(by);
        ProjectCommon.setInputField(element, newValue);
    }

    public void clickEnElBotonUbicadaEnLaParteInferiorDeLaPagina(String buttonName) throws Throwable {
        By by = By.xpath("//input[@id='project-edit-submit']");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    public void clickEnElBreadcrumbItem(String breadcrumbItemName) throws Throwable {
        By by = By.xpath("//a[.//span[.='" + breadcrumbItemName + "']]");
        ProjectCommon.isVisible(by);
        ProjectCommon.clickElement(by);
    }

    public String verificarQueElElCampoDelProyectoCreadoCambioA(String fieldName, String projectName) throws Throwable {
        By by = By.xpath(
                "(//tr[./td/div/a[.='" + projectName +"']]/td)" +
                        "[count(//th[./span/span[.='" + fieldName + "']]/preceding-sibling::*)+1]//text()[last()]/parent::*");
        ProjectCommon.isVisible(by);
        return ProjectCommon.getTextContent(by);
    }

    public void verificarQueElElCampoDelProyectoCambioAInTheProjectSettingsPage(String fieldName, String projectName, String expected) throws Throwable {
        By by = By.xpath("//div[./label[contains(text(), '" + fieldName +"')]]//*[contains(text(), '" + expected + "')]");
        ProjectCommon.isVisible(by);
    }

    public void selectDropdownAndItem(String dropdownName, String dropdownItemName) throws Throwable {
        By byDropDown = By.xpath("//div[./label[contains(text(), '" + dropdownName + "')]]/select");
        By byDropDownItem = By.xpath("//div[./label[contains(text(), '" + dropdownName + "')]]/select/option[contains(text(),'" + dropdownItemName + "')]");
        ProjectCommon.isVisible(byDropDown);
        ProjectCommon.clickElement(byDropDown);
        ProjectCommon.isVisible(byDropDownItem);
        ProjectCommon.clickElement(byDropDownItem);
    }

    public void verificarQueElMensajeDeErrorEsMostrado(String errorMessage, String fieldName) throws Throwable {
        By by = By.xpath("//div[@class='error' and contains(text(), '" + errorMessage + "')]");
        ProjectCommon.elementTobeClickable(by);
    }
}
