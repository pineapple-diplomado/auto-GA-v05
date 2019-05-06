package org.umssdiplo.automationv01.core.managepage.userstories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public class UserStoryLogin extends BasePage {
    @FindBy(id = "username")
    private WebElement emailInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-submit")
    private WebElement continueBtn;

    private static final String PATH_USERNAME = "//input[@id='username']";
    private static final String PATH_PASSWORD = "//input[@id='password']";
    private static final String PATH_SUBMIT = "//button[@id='login-submit']";

    public void setEmail() {
        By byUsername = By.xpath(PATH_USERNAME);
        UserStoryCommonEvents.setInputField(byUsername, PropertyAccessor.getInstance().getUser());
        By byContinue = By.xpath(PATH_SUBMIT);
        UserStoryCommonEvents.clickButton(byContinue);
    }

    public void setPassword() {
        By byPasword = By.xpath(PATH_PASSWORD);
        UserStoryCommonEvents.setInputField(byPasword, PropertyAccessor.getInstance().getPassword());
        By byContinue = By.xpath(PATH_SUBMIT);
        UserStoryCommonEvents.clickButton(byContinue);
        //return new UserStoryBrowseProjects();
    }
}
