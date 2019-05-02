package org.umssdiplo.automationv01.core.managepage.PagesJavierZapata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class CreationTaskDialog extends BasePage {

    public String createIssueButton;
    //public String iconBotonDialogIssue; //ICONO TRES PUNTOS
    public CreationTaskDialog dialogoCreacionTask;

    @FindBy(xpath = "//div[@id='issuetype-single-select']//input[@id='issuetype-field']")
    private WebElement dialogCreationIssue;

    @FindBy(xpath = "//a[@role='presentation' and contains(text(),'Tarea')]")   //CHANGE->Task
    private WebElement selectedTaskItem;

    //@FindBy(id = "summary")
    //@FindBy(xpath = "//*[@id=\"summary\"]")
    @FindBy(id = "summary")
    private WebElement summary;

    //DIV CLASS = "CONTENT"
    @FindBy(xpath = "/html/body/div[21]/div[2]/div[1]/div/form/div[1]/div[2]")
    private WebElement contenido;

    @FindBy(id = "create-issue-submit")
    private  WebElement butonCrear;

    public CreationTaskDialog(){
        createIssueButton = "//button[contains(text(), '%s')]";
        //iconBotonDialogIssue = "button[@title='Abrir el diálogo Crear']";  //CHANGE->Open create dialog
    }

    public void createIssue() {
        CommonEvents.clickButton(dialogCreationIssue);
        CommonEvents.clickButton(selectedTaskItem);
    }


    public void insertSummary(String titulo) {
        CommonEvents.isVisible(contenido);
        CommonEvents.setInputField(summary,titulo);
    }

    public void presionarCreateButton() {
        CommonEvents.clickButton(butonCrear);
    }
}
