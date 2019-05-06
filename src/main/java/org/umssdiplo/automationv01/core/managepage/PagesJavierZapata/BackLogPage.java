package org.umssdiplo.automationv01.core.managepage.PagesJavierZapata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class BackLogPage extends BasePage {

    public String createIssueButton;
    //public String iconBotonDialogIssue; //ICONO TRES PUNTOS

    @FindBy(xpath = "//div[@id='page-body']")
    private WebElement contenedor;

    @FindBy(xpath = "//*[@id=\"breadcrumbs-container\"]/div/div/div[3]/a/span/span")
    private WebElement gettingKeyProyecto;

    @FindBy(xpath = "//button[@original-title='Abrir el diálogo Crear']")
    private WebElement botonTresPuntos;

    @FindBy(xpath = "/html/body/div[4]/div/div[2]/div[2]/div[2]/div[2]/" +
            "div[2]/div/div[4]/div/div/div[2]/div[3]")
    private WebElement contenidoListas;


    public static final String NUEVO_TASK = "//div[@data-tooltip='%s']";

    //@FindBy(xpath ="//span[@aria-label='Solo Mis Incidencias']")
    @FindBy(xpath = "//*[@id=\"ghx-quick-filters\"]/ul/li[3]/ul/li[1]/button")
    private WebElement botonOnlyMyIssues;

    public BackLogPage(){
        CommonEvents.forceWait(5000);
        CommonEvents.waitElementVisible(contenedor);
        createIssueButton = "//button[contains(text(), '%s')]";
        //iconBotonDialogIssue = "button[@title='Abrir el diálogo Crear']";  //Open create dialog
    }

    public void dialogoCrearTask(String nombreBoton) throws InterruptedException {
        CommonEvents.forceWait(5000);
        By issueBy = By.xpath(String.format(createIssueButton, nombreBoton));
        CommonEvents.clickButton(issueBy);
    }

    public CreationTaskDialog dialogoCrearTask2() {
        CommonEvents.forceWait(5000);
        CommonEvents.clickButton(botonTresPuntos);
        return new CreationTaskDialog();
    }


    public boolean checkExistenciaDeUltimoTask(String nombreTask) {
        CommonEvents.forceWait(5000);
        String elemento = gettingKeyProyecto.getText();
        String[] parts = elemento.split(" ");
        String key = parts[0];
        key = key.trim();
        System.out.println("key: "+key);
        CommonEvents.isVisible(contenidoListas);
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

    public PanelConfiguracionTask clickEnUnTask(String tituloTask) {
        CommonEvents.forceWait(5000);
        By clickNuevoTask = By.xpath(String.format(NUEVO_TASK, tituloTask));
        CommonEvents.clickButton(clickNuevoTask);
        return new PanelConfiguracionTask();
    }

    public int checkIssuesNumberUser(String user) {
        CommonEvents.forceWait(5000);
        //CommonEvents.isVisible(contenidoListas);
        List<WebElement> elementsRoot = webDriver.findElements(By.xpath("//div[starts-with(@class,'js-issue')]//" +
                "img[contains(@data-tooltip,'Responsable: ${user}')]"));
        System.out.println("Numero de elementos backlog: "+elementsRoot.size());
        return elementsRoot.size();
    }


    public int checkIssuesNumberUserOnlyMyIssues(String user) {
        CommonEvents.forceWait(5000);
        //CommonEvents.isVisible(contenidoListas);
        //CommonEvents.isPresent(botonOnlyMyIssues);
        CommonEvents.clickButton(botonOnlyMyIssues);
        List<WebElement> elementsRoot = webDriver.findElements(By.xpath("//div[starts-with(@class,'js-issue')]//" +
                "img[contains(@data-tooltip,'Responsable: ${user}')]"));
        System.out.println("Numero de elementos only my issues: "+elementsRoot.size());
        return elementsRoot.size();
    }
}
