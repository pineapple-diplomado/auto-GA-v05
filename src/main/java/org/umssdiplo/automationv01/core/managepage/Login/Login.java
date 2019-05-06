package org.umssdiplo.automationv01.core.managepage.Login;

import org.openqa.selenium.By;
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

    private static final String PATH_USERNAME = "//input[@id='username']";
    private static final String PATH_PASSWORD = "//input[@id='password']";
    private static final String PATH_SUBMIT = "//button[@id='login-submit']";

    public void setEmail(String email) {
        By byUsername = By.xpath(PATH_USERNAME);
        CommonEvents.setInputField(byUsername, email);
        By byContinue = By.xpath(PATH_SUBMIT);
        CommonEvents.clickButton(byContinue);
    }

    public BrowseProjects setPassword(String password) {
        By byPasword = By.xpath(PATH_PASSWORD);
        CommonEvents.setInputField(byPasword, password);
        By byContinue = By.xpath(PATH_SUBMIT);
        CommonEvents.clickButton(byContinue);
        return new BrowseProjects();
    }
}
