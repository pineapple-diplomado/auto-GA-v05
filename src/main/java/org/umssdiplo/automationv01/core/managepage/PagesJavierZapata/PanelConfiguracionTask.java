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


    //@FindBy(xpath = "//input[contains(@placeholder='Añadir un comentario')]")   //CHANGE Add a comment...
    //private WebElement fieldComentario;
    private static final String FIELD_COMENTARIO = "//input[contains(@placeholder,'Añadir un comentario')]";
    private static final String FIELD_COMENTARIO2 = "//div[contains(@contenteditable,'true')]";
    private static final String BOTON_SAVE_FIELD_COMENTARIO = "//button[.//span[contains(text(),'Save')]]";



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

    //@FindBy(xpath ="//input[@placeholder='Añadir un comentario...']")
    @FindBy(xpath = "//*[@id=\"ghx-detail-view\"]/div/div[2]/div/div/div/div[3]/div/div[1]/div[1]/div/div/div/div/" +
            "span/span/span/div/div/div[2]/div/div/div/div/input")
    private WebElement insertarComentario;


    @FindBy(xpath = "//*[@id=\"ghx-detail-view\"]/div/div[2]/div/div/div/div[3]/div/div[1]/div[1]/div/div[1]/div/span/" +
            "span/span/div/div/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div/div[2]/p")
    private WebElement insertarComentario2;  //Este elemento se activa luego de hacer el primer click.



    public void setSelectInProgress() {
        CommonEvents.clickButton(selectedItems);
        CommonEvents.clickButton(selectInProgress);
    }

    public String verificandoInProgress() {
        String status = selectInProgress.getText();
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

    public void anadirNuevoComentario(String nuevoComentario) {

        By primerField = By.xpath(FIELD_COMENTARIO);
        WebElement element = webDriver.findElement(primerField);
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        eventFiringWebDriver.executeScript("arguments[0].scrollIntoView()", element);
        //CommonEvents.clickButton(primerField);
        CommonEvents.clickButton(element);

        By segundaCampoMostrado = By.xpath(FIELD_COMENTARIO2);
        CommonEvents.setInputFieldBy(segundaCampoMostrado, nuevoComentario);

        By botonBySaveComentario = By.xpath(BOTON_SAVE_FIELD_COMENTARIO);
        CommonEvents.clickButton(botonBySaveComentario);



    }
}
