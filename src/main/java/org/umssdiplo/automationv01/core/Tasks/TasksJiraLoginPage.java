package org.umssdiplo.automationv01.core.Tasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public class TasksJiraLoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-submit")
    private WebElement loginBtn;

    //public TasksHomePage setCredentials() {
    public TasksBackLogPage setCredentials() {
        String username = PropertyAccessor.getInstance().getUser();
        TasksCommonEvents.setInputField(usernameInputField, "pineapple.automation2@gmail.com");
        clickButton();
        String password = PropertyAccessor.getInstance().getPassword();
        TasksCommonEvents.setInputField(passwordInputField, "Control123!");
        clickButton();
        //return new TasksHomePage();
        return new TasksBackLogPage();
    }

    private void clickButton() {
        TasksCommonEvents.clickButton(loginBtn);
    }

}
