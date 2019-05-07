package org.umssdiplo.automationv01.core.Tasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;

public class TasksCreationTaskDialog extends BasePage {

    public String createIssueButton;
    //public String iconBotonDialogIssue; //ICONO TRES PUNTOS
    public TasksCreationTaskDialog dialogoCreacionTask;

    @FindBy(xpath = "//div[@id='issuetype-single-select']//input[@id='issuetype-field']")
    private WebElement dialogCreationIssue;

    @FindBy(xpath = "//a[@role='presentation' and contains(text(),'Task')]")   //CHANGE->Task
    private WebElement selectedTaskItem;

    @FindBy(id = "summary")
    private WebElement summary;

    //DIV CLASS = "CONTENT"
    @FindBy(xpath = "/html/body/div[21]/div[2]/div[1]/div/form/div[1]/div[2]")
    private WebElement contenido;

    @FindBy(id = "create-issue-submit")
    private  WebElement butonCrear;

    public TasksCreationTaskDialog(){
        createIssueButton = "//button[contains(text(), '%s')]";
        //iconBotonDialogIssue = "button[@title='Abrir el diálogo Crear']";  //CHANGE->Open create dialog
    }

    public void createIssue() {
        TasksCommonEvents.forceWait(5000);
        TasksCommonEvents.clickButton(dialogCreationIssue);
        TasksCommonEvents.clickButton(selectedTaskItem);
    }


    public void insertSummary(String titulo) {
        TasksCommonEvents.forceWait(5000);
        TasksCommonEvents.isVisible(contenido);
        TasksCommonEvents.setInputField(summary,titulo);
    }

    public void presionarCreateButton() {
        TasksCommonEvents.forceWait(5000);
        TasksCommonEvents.clickButton(butonCrear);
    }
}
