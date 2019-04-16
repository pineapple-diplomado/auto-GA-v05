package org.umssdiplo.automationv01.core.managepage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ProjectManagement extends BasePage {
    @FindBy(id = "Nombre")
    private WebElement accidenteNombre;
    @FindBy(id = "Descripcion")
    private WebElement accidenteDescripcion;
    @FindBy(id = "AccidenteTipo")
    private WebElement accidenteTipo;
    @FindBy(id = "Severidad")
    private WebElement severidad;
    @FindBy(id = "GuardarAccidente")
    private WebElement guardarAccidente;

    @FindBy(xpath = "//*[@class=\"sc-EHOje dCmFoj\"]")
    private WebElement createProject;

    @FindBy(id = "EditarAccidente")
    private WebElement editarAccidente;
    @FindBy(id = "BorrarAccidente")
    private WebElement borrarAccidente;

    public ProjectManagement() {
    }



    public void setNombreField(String nombre) {
        CommonEvents.setInputField(accidenteNombre, nombre);
    }

    public void setDescripcionField(String descripcion) {
        CommonEvents.setInputField(accidenteDescripcion, descripcion);
    }

    public void setTipoField(String tipo) {
        CommonEvents.selectValue(accidenteTipo, tipo);
    }

    public void setSeveridadField(String severidadValue) {
        CommonEvents.selectValue(severidad, severidadValue);
    }

    public void setEditarAccidentFields() {
        CommonEvents.setInputField(accidenteNombre, "AccidenteModificado1");
        CommonEvents.setInputField(accidenteDescripcion, "DescripcionModificada1");
        CommonEvents.selectValue(accidenteTipo, "AccidenteDePersonal");
        CommonEvents.selectValue(severidad, "Baja");
    }

    public void clickCreateProject() {
        CommonEvents.clickButton(this.createProject);
    }

    public void clickGuardarAccidente() {
        CommonEvents.clickButton(this.guardarAccidente);
    }

    public void clickEditarAccidente() {
        By by = By.xpath(
                "//td[contains(text(),'Accidente1')]/following-sibling::td/button[@id='EditarAccidente']");
        CommonEvents.clickElement(by);
    }

    public void clickBorrarAccidente() {
        By by = By.xpath(
                "//td[contains(text(),'AccidenteModificado1')]/following-sibling::td/button[@id='BorrarAccidente']");
        CommonEvents.clickElement(by);
    }

    public boolean isAccidentCreated() {
        By by = By.xpath(
                "//td[contains(text(),'Accidente1')]");
        CommonEvents.isVisible(by);
        WebElement createdAccident = CommonEvents.getElement(by);
        String accidentCreated = createdAccident.getText();
        return accidentCreated.equals("Accidente1");
    }

    public boolean isAccidentEdited() {
        By by = By.xpath(
                "//td[contains(text(),'AccidenteModificado1')]");
        CommonEvents.isVisible(by);
        WebElement editedAccident = CommonEvents.getElement(by);
        String accidentEdited = editedAccident.getText();
        return accidentEdited.equals("AccidenteModificado1");
    }

    public boolean isAccidentDeleted() {
        By by = By.xpath("//td[contains(text(),'AccidenteModificado1')]");
        try {
            CommonEvents.isNotVisible(by);
            CommonEvents.getElement(by);
        } catch (NoSuchElementException ex) {
            return true;
        }
        return false;
    }
}
