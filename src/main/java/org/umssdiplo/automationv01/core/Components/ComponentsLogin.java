package org.umssdiplo.automationv01.core.Components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ComponentsLogin extends BasePage {
    @FindBy(name = "email")
    private WebElement usernameInputField;

    @FindBy(name = "password")
    private WebElement passwordInputField;

    @FindBy(css = ".btn-primary.btn-block")
    private WebElement loginBtn;

    @FindBy(id = "username")
    private WebElement emailInputField;

    @FindBy(id = "login-submit")
    private WebElement continueBtn;

    @FindBy(id = "password")
    private WebElement passwordJiraInputField;

    public void setCredentials() {
        CommonEvents.setInputField(usernameInputField,"sosiego14@outlook.com" );
        CommonEvents.setInputField(passwordInputField, "emerger14");
        CommonEvents.clickButton(loginBtn);
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

    public Components setAllCredentials() throws InterruptedException {
        CommonEvents.setInputField(emailInputField, "pineapple.automation2@gmail.com");
        this.clickContinueButton();
        CommonEvents.setInputField(passwordJiraInputField, "Control123!");
        CommonEvents.clickButton(continueBtn);
        return new Components();
    }
}
