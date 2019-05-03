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

    @FindBy(xpath = "//button[@original-title='Abrir el diálogo Crear']")
    private WebElement botonTresPuntos;

    @FindBy(xpath = "/html/body/div[4]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div/div[2]/div[3]")
    private WebElement contenidoListas;

    public static final String NUEVO_TASK = "//div[@data-tooltip='%s']";

    public BackLogPage(){
        createIssueButton = "//button[contains(text(), '%s')]";
        //iconBotonDialogIssue = "button[@title='Abrir el diálogo Crear']";  //Open create dialog
    }

    public void dialogoCrearTask(String nombreBoton) {
        By issueBy = By.xpath(String.format(createIssueButton, nombreBoton));
        CommonEvents.clickButton(issueBy);
    }

    public CreationTaskDialog dialogoCrearTask2() {
        CommonEvents.clickButton(botonTresPuntos);
        return new CreationTaskDialog();
    }


    public boolean checkExistenciaDeUltimoTask(String nombreTask) {
        CommonEvents.isVisible(contenidoListas);
        int maximo = 0; int auxiliar = 0;
        List<WebElement> elementsRoot = webDriver.findElements(By.xpath("//div[starts-with(@class,'js-issue')]//a[contains(text(),'PROY')]"));
        maximo = getmax(elementsRoot);
        auxiliar = getNumber(elementsRoot.get(elementsRoot.size() - 1));
        System.out.println("maximo: "+maximo+ "auxiliar: "+auxiliar);
        return auxiliar==maximo;
    }

    private int getmax(List<WebElement> elementsRoot) {
        int maximo = 0; int auxiliar = 0;
        for(int i = 0; i < elementsRoot.size(); ++i) {
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
        By clickNuevoTask = By.xpath(String.format(NUEVO_TASK, tituloTask));
        CommonEvents.clickButton(clickNuevoTask);
        return new PanelConfiguracionTask();
    }
}
