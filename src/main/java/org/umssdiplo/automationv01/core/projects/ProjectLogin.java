package org.umssdiplo.automationv01.core.projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public class ProjectLogin extends BasePage {
    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement loginButton;

    public ProjectManagement login() {
        String username = PropertyAccessor.getInstance().getUser();
        String password = PropertyAccessor.getInstance().getPassword();
        CommonEvents.setInputField(userNameField, username);
        CommonEvents.clickButton(this.loginButton);
        CommonEvents.setInputField(this.passwordField, password);
        CommonEvents.clickButton(this.loginButton);
        return new ProjectManagement();
    }
}
