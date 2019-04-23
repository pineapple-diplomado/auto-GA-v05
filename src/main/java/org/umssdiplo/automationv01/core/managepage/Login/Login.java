package org.umssdiplo.automationv01.core.managepage.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public class Login extends BasePage {
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement usernameInputField;

    @FindBy(id = "login-submit")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordInputField;



    public void setCredentials() {
        String username = PropertyAccessor.getInstance().getUser();
//        String password = PropertyAccessor.getInstance().getPassword();
        CommonEvents.setInputField(usernameInputField, username);
//        CommonEvents.setInputField(passwordInputField, password);
        CommonEvents.clickButton(loginBtn);

        String password = PropertyAccessor.getInstance().getPassword();
    }
}
