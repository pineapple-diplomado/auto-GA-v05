package org.umssdiplo.automationv01.core.managepage.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.page.BrowseProjects;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class Login extends BasePage {
    @FindBy(id = "username")
    private WebElement emailInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-submit")
    private WebElement continueBtn;


    public void setEmail(String email) {
        CommonEvents.setInputField(emailInputField, email);
        CommonEvents.clickButton(continueBtn);
    }

    public BrowseProjects setPassword(String password) {
        CommonEvents.setInputField(passwordInputField, password);
        CommonEvents.clickButton(continueBtn);
        return new BrowseProjects();
    }
}
