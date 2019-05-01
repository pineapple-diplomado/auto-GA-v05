package org.umssdiplo.automationv01.core.managepage.PagesJavierZapata;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public class JiraLoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-submit")
    private WebElement loginBtn;

    public HomePage setCredentials() {
        String username = PropertyAccessor.getInstance().getUser();
        CommonEvents.setInputField(usernameInputField, username);
        clickButton();
        String password = PropertyAccessor.getInstance().getPassword();
        CommonEvents.setInputField(passwordInputField, password);
        clickButton();
        return new HomePage();

    }

    private void clickButton() {
        CommonEvents.clickButton(loginBtn);
    }

}
