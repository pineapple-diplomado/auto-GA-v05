package org.umssdiplo.automationv01.core.managepage.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public class Login extends BasePage {

    @FindBy(id = "gray_link")
    private WebElement loginBtnMainPage;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInputField;

    @FindBy(id = "login-submit")
    private WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordInputField;

    @FindBy(id = "login-submit")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"form-login\"]/div[1]/div/span[1]") //No funciona con css, solo con xpath
    private WebElement editIconBtn;


    @FindBy(xpath = "//span[@class='sc-cmTdod kRpRqx']")
    private WebElement spanElement;


    public void clickLoginBtnMainPage() {
        CommonEvents.clickButton(loginBtnMainPage);
    }

    public void setEmailCredential() {
        String username = PropertyAccessor.getInstance().getUser();
        CommonEvents.setInputField(usernameInputField, username);
    }

    public void clickContinue() {
        CommonEvents.clickButton(continueBtn);
    }

    public void setPasswordCredential() {
        String password = PropertyAccessor.getInstance().getPassword();
        CommonEvents.setInputField(passwordInputField, password);

    }

    public void clickLogin() {
        CommonEvents.clickButton(loginBtn);
    }

    public void clickEditIconBtn() throws InterruptedException {
//        String usernameedit = PropertyAccessor.getInstance().getUserEdit();
        CommonEvents.clickClikable(editIconBtn);
//        CommonEvents.setInputField(usernameInputField, usernameedit);
    }

    public boolean validateInputIsDisplayed() throws InterruptedException {
        return CommonEvents.isVisible(usernameInputField);
//        CommonEvents.setInputField(usernameInputField, usernameedit);
    }

    public void setEmailCredentialNotExist() {
        String usernamenotexist = PropertyAccessor.getInstance().getUserNotExist();
        CommonEvents.setInputField(usernameInputField, usernamenotexist);
    }

    public boolean validateSpamIsDisplayed() {
        return CommonEvents.isVisible(spanElement);
    }
}
