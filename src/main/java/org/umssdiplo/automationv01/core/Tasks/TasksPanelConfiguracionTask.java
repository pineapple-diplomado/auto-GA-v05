package org.umssdiplo.automationv01.core.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.umssdiplo.automationv01.core.managepage.BasePage;

public class TasksPanelConfiguracionTask extends BasePage {


    //@FindBy(xpath = "//input[contains(@placeholder='Añadir un comentario')]")   //CHANGE Add a comment...
    //private WebElement fieldComentario;
    private static final String FIELD_COMENTARIO = "//input[contains(@placeholder,'Add a comment')]";
    private static final String FIELD_COMENTARIO2 = "//div[contains(@contenteditable,'true')]";
    private static final String BOTON_SAVE_FIELD_COMENTARIO = "//button[.//span[contains(text(),'Save')]]";

    private static final String BOTON_DELETE_COMENTARIO = "//div[@id='ghx-detail-view']//span[.//text()='Delete']";
    private static final String PRESIONAR_DELETE = "//div[@id='ghx-detail-view']//button[@class='sc-EHOje EWZph']" +
            "//span[.//text()='Delete']";



    @FindBy(xpath = "//*[@id=\"ghx-detail-view\"]/div/div[2]/div/div/div/div[3]/div/div[1]/div[1]/div/div/div/div/" +
            "div[3]/div[2]/div/div/div/div[1]/div/div/button/span")   ////span[contains(text(), 'Por hacer')]
    private WebElement selectedItems;

    @FindBy(xpath ="//span[contains(text(), 'In Progress')]")
    private WebElement selectInProgress;

    @FindBy(xpath ="//span[@aria-label='Create subtask']")
    private WebElement botonCreateSubTask;  //boton icono inicial de subtask

    @FindBy(xpath ="//h2[.//text()='Subtasks']")
    private WebElement labelSubtareas;

    @FindBy(xpath ="//input[@placeholder='What needs to be done?']")
    private WebElement fieldInsertarSubTask;

    @FindBy(xpath ="//span[.//text()='Create']")
    private WebElement botonCrearSBT;  //Boton crear de subtask


    @FindBy(xpath ="//div[.//text()='%s']")
    private WebElement savedSubTask;

    @FindBy(xpath ="//span[@aria-label='Close']")
    private WebElement botonCerrarPanel;  //boton icono inicial de subtask

    //@FindBy(xpath ="//div[@id='ghx-detail-view']//span[.//text()='Borrar']")
    //private WebElement botonDeleteComment;

    @FindBy(xpath ="//div[@class='Modal__Dialog-sc-1jmnqyd-3 ggbguk']")
    private WebElement contenedorDialogoDelete;


    public void setSelectInProgress() {
        TasksCommonEvents.forceWait(10000);
        TasksCommonEvents.clickButton(selectedItems);
        TasksCommonEvents.forceWait(10000);
        TasksCommonEvents.clickButton(selectInProgress);
    }

    public String verificandoInProgress() {
        TasksCommonEvents.forceWait(10000);
        String status = selectInProgress.getText();
        return status;
    }

    public void clickCreacionSubTask() {
        TasksCommonEvents.forceWait(10000);
        TasksCommonEvents.clickButton(botonCreateSubTask);
    }

    public void checkSubTareasDisplayedFormulario() {
        TasksCommonEvents.forceWait(10000);
        TasksCommonEvents.isPresent(labelSubtareas);
    }

    public void insertarSubTask(String contenidoSubTask) {
        TasksCommonEvents.forceWait(10000);
        TasksCommonEvents.setInputField(fieldInsertarSubTask, contenidoSubTask);
    }

    public void clickBotonCrearSubTask() {
        TasksCommonEvents.forceWait(10000);
        TasksCommonEvents.clickButton(botonCrearSBT);

    }


    public void checkSubTareaSaved(String subTask) {
        TasksCommonEvents.forceWait( 10000);
        WebElement element = webDriver.findElement(By.xpath("//div[.//text()='Nuevo subtask creado']")); //${subTask}
    }

    public void cerrarPanelConfiguration() {
        TasksCommonEvents.forceWait(5000);
        TasksCommonEvents.clickButton(botonCerrarPanel);
    }

    public void borrarComentario(String comentario) {
        TasksCommonEvents.forceWait(10000);

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);

//        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"ghx-detail-view\"]/div/div[2]/div/div/div/" +
//                "div[2]/div/div[1]/div[1]/div/div/div/div/span/span/div/div/div[2]/div/div[3]/div[2]/span/button"));

        By delete = By.xpath(PRESIONAR_DELETE);
        WebElement element = webDriver.findElement(delete);

        eventFiringWebDriver.executeScript("arguments[0].scrollIntoView()", element);
        TasksCommonEvents.forceWait(10000);
        TasksCommonEvents.clickButton(element);

        //FUNCIONA :)
        //WebElement aceptar = webDriver.findElement(By.xpath("//*[@id=\"jira\"]/div[11]/div[4]/div/div[3]/div[2]/div/" +
        //        "div/div[3]/div/div/div/button"));

        WebElement aceptar = webDriver.findElement(By.xpath("//span[.//text()='OK']"));
        ////*[@id="jira"]/div[11]/div[4]/div/div[3]/div[2]/div/div/div[3]/div/div/div/button
        //TasksCommonEvents.isPresent(contenedorDialogoDelete);
        TasksCommonEvents.forceWait(5000);
        TasksCommonEvents.clickButton(aceptar);
    }

    public void anadirNuevoComentario(String nuevoComentario) {
        TasksCommonEvents.forceWait(5000);

        By primerField = By.xpath(FIELD_COMENTARIO);
        WebElement element = webDriver.findElement(primerField);

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        eventFiringWebDriver.executeScript("arguments[0].scrollIntoView()", element);
        //TasksCommonEvents.clickButton(primerField);
        TasksCommonEvents.forceWait(5000);
        TasksCommonEvents.clickButton(element);

        By segundaCampoMostrado = By.xpath(FIELD_COMENTARIO2);
        TasksCommonEvents.setInputFieldBy(segundaCampoMostrado, nuevoComentario);
        TasksCommonEvents.forceWait(5000);

        By botonBySaveComentario = By.xpath(BOTON_SAVE_FIELD_COMENTARIO);
        TasksCommonEvents.clickButton(botonBySaveComentario);



    }
}
