package org.umssdiplo.automationv01.core.managepage.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;

public class Login extends BasePage {
    @FindBy(name = "email")
    private WebElement usernameInputField;

    @FindBy(name = "password")
    private WebElement passwordInputField;

    @FindBy(css = ".btn-primary.btn-block")
    private WebElement loginBtn;

    public void setCredentials() {
//        String username = PropertyAccessor.getInstance().getUser();
//        String password = PropertyAccessor.getInstance().getPassword();
//        TasksCommonEvents.setInputField(usernameInputField, username);
//        TasksCommonEvents.setInputField(passwordInputField, password);
//        TasksCommonEvents.clickButton(loginBtn);
    }
}
