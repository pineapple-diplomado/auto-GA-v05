package org.umssdiplo.automationv01.core.managepage.JiraLanzamiento;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public final class Lanzamiento extends BasePage {

    @FindBy(xpath = "//button[@id=\"login-submit\"]")
    private WebElement loginBtn;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement usernameInputField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//a[@class='css-t3yiul']")
    private WebElement linkLanzamiento;

    @FindBy(xpath = "//button[@class='sc-EHOje dCmFoj']")
    private WebElement newReleaseButton;

    @FindBy(xpath = "//input[@class='sc-tilXH xhjOD']")
    private WebElement releaseTitle;

    @FindBy(xpath = "//button[@class='sc-EHOje dCmFoj']")
    private WebElement submitReleaseButton;

    public void Authentication()
    {
        String username = PropertyAccessor.getInstance().getUser();
        CommonEvents.setInputField(usernameInputField, username);
        CommonEvents.clickButton(loginBtn);
        String password = PropertyAccessor.getInstance().getPassword();
        CommonEvents.setInputField(passwordInputField, password);
        CommonEvents.clickButton(loginBtn);
    }

    public void goToReleasePage()
    {
        CommonEvents.forceWait(10000);
        CommonEvents.clickButton(linkLanzamiento);
    }

    public void openNewReleaseForm()
    {
        CommonEvents.clickButton(newReleaseButton);
    }

    public  void submitForm()
    {
        String title = "version 2";
        CommonEvents.setInputField(releaseTitle, title);
        CommonEvents.forceWait(2000);
        CommonEvents.clickButton(submitReleaseButton);
    }
}
