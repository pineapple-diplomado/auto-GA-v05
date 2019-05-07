package org.umssdiplo.automationv01.core.managepage.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.components.Components;
import org.umssdiplo.automationv01.core.managepage.home.Home;
import org.umssdiplo.automationv01.core.managepage.projectPage.ProjectPage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public class Login extends BasePage {
    @FindBy(name = "email")
    private WebElement usernameInputField;

    @FindBy(name = "password")
    private WebElement passwordInputField;

    @FindBy(css = ".btn-primary.btn-block")
    private WebElement loginBtn;

//    @FindBy(xpath = "//input[@placeholder='Enter email']")
//    private WebElement emailInputField;

    @FindBy(id = "username")
    private WebElement emailInputField;

    @FindBy(id = "login-submit")
    private WebElement continueBtn;

    @FindBy(id = "password")
    private WebElement passwordJiraInputField;

    public void setCredentials() {
//        String username = PropertyAccessor.getInstance().getUser();
//        String password = PropertyAccessor.getInstance().getPassword();
//        TasksCommonEvents.setInputField(usernameInputField, username);
//        TasksCommonEvents.setInputField(passwordInputField, password);
//        TasksCommonEvents.clickButton(loginBtn);
    }

    public void setPassword(String password) {

        CommonEvents.setInputField(passwordJiraInputField, password);
    }

    public void setEmail(String arg0) {

        CommonEvents.setInputField(emailInputField, arg0);
    }

    public void clickContinueButton() throws InterruptedException{
        CommonEvents.forceWait(1000);
        CommonEvents.clickButton(continueBtn);
    }

    public Components login() throws InterruptedException {
        CommonEvents.clickButton(continueBtn);
        CommonEvents.forceWait(1000);
        return new Components();
    }

    public ProjectPage setAllCredentials() throws InterruptedException {
        CommonEvents.setInputField(emailInputField, "isa.gric@gmail.com");
        this.clickContinueButton();
        CommonEvents.setInputField(passwordJiraInputField, "sosiego14");
        CommonEvents.clickButton(continueBtn);
        return new ProjectPage();
    }
}
