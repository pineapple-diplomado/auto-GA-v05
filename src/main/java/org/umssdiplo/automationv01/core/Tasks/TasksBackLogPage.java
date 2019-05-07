package org.umssdiplo.automationv01.core.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;

import java.util.List;

public class TasksBackLogPage extends BasePage {

    public String createIssueButton;
    //public String iconBotonDialogIssue; //ICONO TRES PUNTOS

    @FindBy(xpath = "//div[@id='page-body']")
    private WebElement contenedor;

    @FindBy(xpath = "//*[@id=\"breadcrumbs-container\"]/div/div/div[3]/a/span/span")
    private WebElement gettingKeyProyecto;

    @FindBy(xpath = "//button[@original-title='Open create dialog']")
    private WebElement botonTresPuntos;

    @FindBy(xpath = "/html/body/div[4]/div/div[2]/div[2]/div[2]/div[2]/" +
            "div[2]/div/div[4]/div/div/div[2]/div[3]")
    private WebElement contenidoListas;


    public static final String NUEVO_TASK = "//div[@data-tooltip='%s']";

    //@FindBy(xpath ="//span[@aria-label='Solo Mis Incidencias']")
    @FindBy(xpath = "//*[@id=\"ghx-quick-filters\"]/ul/li[3]/ul/li[1]/button")
    private WebElement botonOnlyMyIssues;

    public TasksBackLogPage(){
        TasksCommonEvents.forceWait(5000);
        TasksCommonEvents.waitElementVisible(contenedor);
        createIssueButton = "//button[contains(text(), '%s')]";
        //iconBotonDialogIssue = "button[@title='Abrir el diálogo Crear']";  //Open create dialog
    }

    public void dialogoCrearTask(String nombreBoton) throws InterruptedException {
        TasksCommonEvents.forceWait(5000);
        By issueBy = By.xpath(String.format(createIssueButton, nombreBoton));
        TasksCommonEvents.clickButton(issueBy);
    }

    public TasksCreationTaskDialog dialogoCrearTask2() {
        TasksCommonEvents.forceWait(5000);
        TasksCommonEvents.clickButton(botonTresPuntos);
        return new TasksCreationTaskDialog();
    }


    public boolean checkExistenciaDeUltimoTask(String nombreTask) {
        TasksCommonEvents.forceWait(5000);
        String elemento = gettingKeyProyecto.getText();
        String[] parts = elemento.split(" ");
        String key = parts[0];
        key = key.trim();
        System.out.println("key: "+key);
        TasksCommonEvents.isVisible(contenidoListas);
        int maximo = 0; int auxiliar = 0;
        List<WebElement> elementsRoot = webDriver.findElements(By.xpath("//div[starts-with(@class,'js-issue')]//" +
                "a[contains(text(), '"+key+"')]"));
        maximo = getmax(elementsRoot);
        auxiliar = getNumber(elementsRoot.get(elementsRoot.size() - 1));
        System.out.println("maximo: "+maximo+ "auxiliar: "+auxiliar);
        return auxiliar==maximo;
    }

    private int getmax(List<WebElement> elementsRoot) {
        int maximo = 0; int auxiliar = 0;
        for(int i = 0; i < elementsRoot.size(); i++) {
            auxiliar = getNumber(elementsRoot.get(i));
            if(auxiliar>maximo){
                maximo = auxiliar;
            }
        }
        return maximo;
    }

    //PROY-#
    private int getNumber(WebElement element){
        int auxiliar=0;
        String dato = element.getText();
        String[] parts = dato.split("-");
        String part2 = parts[1];
        auxiliar = Integer.parseInt(part2);
        return auxiliar;
    }

    public TasksPanelConfiguracionTask clickEnUnTask(String tituloTask) {
        TasksCommonEvents.forceWait(5000);
        By clickNuevoTask = By.xpath(String.format(NUEVO_TASK, tituloTask));
        TasksCommonEvents.clickButton(clickNuevoTask);
        return new TasksPanelConfiguracionTask();
    }

    public int checkIssuesNumberUser(String user) {
        TasksCommonEvents.forceWait(5000);
        //TasksCommonEvents.isVisible(contenidoListas);
        List<WebElement> elementsRoot = webDriver.findElements(By.xpath("//div[starts-with(@class,'js-issue')]//" +
                "img[contains(@data-tooltip,'Assignee: ${user}')]"));
        System.out.println("Numero de elementos backlog: "+elementsRoot.size());
        return elementsRoot.size();
    }


    public int checkIssuesNumberUserOnlyMyIssues(String user) {
        TasksCommonEvents.forceWait(5000);
        //TasksCommonEvents.isVisible(contenidoListas);
        //TasksCommonEvents.isPresent(botonOnlyMyIssues);
        TasksCommonEvents.clickButton(botonOnlyMyIssues);
        List<WebElement> elementsRoot = webDriver.findElements(By.xpath("//div[starts-with(@class,'js-issue')]//" +
                "img[contains(@data-tooltip,'Assignee: ${user}')]"));
        System.out.println("Numero de elementos only my issues: "+elementsRoot.size());
        return elementsRoot.size();
    }
}
