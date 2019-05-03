package org.umssdiplo.automationv01.core.managepage.PagesJavierZapata;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class PanelConfiguracionTask extends BasePage {


    @FindBy(xpath = "//input[@placeholder='Añadir un comentario…']")   //CHANGE Add a comment...
    private WebElement fieldComentario;

    //@FindBy(xpath = "//*[@id=\"ghx-detail-view\"]/div/div[2]/div/div/div/div[3]/div/div[1]/div[1]/div/div/div/div/div[3]/div[2]/div/div/div/div[1]/div/div/button")
    @FindBy(xpath = "//*[@id=\"ghx-detail-view\"]/div/div[2]/div/div/div/div[3]/div/div[1]/div[1]/div/div/div/div/" +
            "div[3]/div[2]/div/div/div/div[1]/div/div/button/span")   ////span[contains(text(), 'Por hacer')]
    private WebElement selectedItems;

    @FindBy(xpath ="//span[contains(text(), 'In Progress')]")
    private WebElement selectInProgress;

    @FindBy(xpath ="//span[@aria-label='Create subtask']")
    private WebElement botonCreateSubTask;  //boton icono inicial de subtask

    @FindBy(xpath ="//h2[.//text()='Subtareas']")
    private WebElement labelSubtareas;

    @FindBy(xpath ="//input[@placeholder='¿Qué hay que hacer?']")
    private WebElement fieldInsertarSubTask;

    //@FindBy(xpath ="//button[contains(@class='sc-EHOje dCmFoj')]//span[contains(text(), 'Crear')]")
    @FindBy(xpath ="//*[@id=\"ghx-detail-view\"]/div/div[2]/div/div/div/div[3]/div/div[1]/div[1]/div/div/div/div/" +
            "div[4]/div[3]/div[2]/div[2]/button[1]/span/span")
    private WebElement botonCrearSBT;  //Boton crear de subtask

    @FindBy(xpath ="//div[.//text()='%s']")
    private WebElement savedSubTask;

    @FindBy(xpath ="//span[@aria-label='Cerrar']")
    private WebElement botonCerrarPanel;  //boton icono inicial de subtask

    @FindBy(xpath ="//div[@id='ghx-detail-view']//span[.//text()='Borrar']")
    private WebElement botonDeleteComment;

    @FindBy(xpath ="//div[@class='Modal__Dialog-sc-1jmnqyd-3 ggbguk']")
    private WebElement contenedorDialogoDelete;

    public void setSelectInProgress() {
        CommonEvents.clickButton(selectedItems);
        CommonEvents.clickButton(selectInProgress);
    }

    public String verificandoInProgress() {
        String status = selectedItems.getText();
        return status;
    }

    public void clickCreacionSubTask() {
        CommonEvents.clickButton(botonCreateSubTask);
    }

    public void checkSubTareasDisplayedFormulario() {
        CommonEvents.isPresent(labelSubtareas);
    }

    public void insertarSubTask(String contenidoSubTask) {
        CommonEvents.setInputField(fieldInsertarSubTask, contenidoSubTask);
    }

    public void clickBotonCrearSubTask() {
//        WebDriverWait wait = new WebDriverWait(webDriver, 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class='sc-EHOje dCmFoj')]//span[contains(text(), 'Crear')]")));
//        WebElement ele5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class='sc-EHOje dCmFoj')]//span[contains(text(), 'Crear')]")));
//        CommonEvents.clickButton(ele5);
        CommonEvents.clickButton(botonCrearSBT);

    }


    public void checkSubTareaSaved(String subTask) {
        WebElement element = webDriver.findElement(By.xpath("//div[.//text()='Nuevo subtask creado']")); //${subTask}
    }

    public void cerrarPanelConfiguration() {
        CommonEvents.clickButton(botonCerrarPanel);
    }

    public void borrarComentario(String comentario) {
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        //eventFiringWebDriver.executeScript("document.querySelector('#ghx-detail-view').scrollTop = 2500");
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"ghx-detail-view\"]/div/div[2]/div/div/div/" +
                "div[2]/div/div[1]/div[1]/div/div/div/div/span/span/div/div/div[2]/div/div[3]/div[2]/span/button"));
        eventFiringWebDriver.executeScript("arguments[0].scrollIntoView()", element);
        CommonEvents.clickButton(element);
        WebElement aceptar = webDriver.findElement(By.xpath("//*[@id=\"jira\"]/div[12]/div[4]/div/div[3]/div[2]/div/" +
                "div/div[3]/div/div/div/button"));
        //CommonEvents.isPresent(contenedorDialogoDelete);
        CommonEvents.clickButton(aceptar);
    }
}
