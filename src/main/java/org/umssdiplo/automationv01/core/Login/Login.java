package org.umssdiplo.automationv01.core.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
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


    /*
        Segunda parte
    */

    @FindBy(xpath = "//span[@class='sc-eNQAEJ llDNh']")
    private WebElement spanIconElement;


    @FindBy(xpath = "//*[@id=\"resetPassword\"]/span")
    private WebElement cantLogInLink;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div/header/h1")
    private WebElement cantLogInTitle;

    @FindBy(id = "google-signin-button")
    private WebElement logInWithGoogleBtn;


    @FindBy(xpath = "//div[@id='login-error']/span")
    private WebElement msgPassError;


    public void clickLoginBtnMainPage() {
        LoginCommonEvents.clickButton(loginBtnMainPage);
    }

    public void setEmailCredential() {
        String username = PropertyAccessor.getInstance().getUser();
        LoginCommonEvents.setInputField(usernameInputField, username);
    }

    public void clickContinue() {
        LoginCommonEvents.clickButton(continueBtn);
    }

    public void setPasswordCredential() {
        String password = PropertyAccessor.getInstance().getPassword();
        LoginCommonEvents.setInputField(passwordInputField, password);

    }

    public void clickLogin() {
        LoginCommonEvents.clickButton(loginBtn);
    }

    public void clickEditIconBtn() throws InterruptedException {
//        String usernameedit = PropertyAccessor.getInstance().getUserEdit();
        LoginCommonEvents.clickClikable(editIconBtn);
//        CommonEvents.setInputField(usernameInputField, usernameedit);
    }

    public boolean validateInputIsDisplayed() throws InterruptedException {
        return LoginCommonEvents.isVisible(usernameInputField);
//        CommonEvents.setInputField(usernameInputField, usernameedit);
    }

    public void setEmailCredentialNotExist() {
        String usernamenotexist = PropertyAccessor.getInstance().getUserNotExist();
        LoginCommonEvents.setInputField(usernameInputField, usernamenotexist);
    }

    public boolean validateSpanIsDisplayed() {
        return LoginCommonEvents.isVisible(spanElement);
    }

    /*
        Segunda parte
    */


    public boolean validateSpanIconIsDisplayed() throws InterruptedException {
        return LoginCommonEvents.isVisible(spanIconElement);
    }


    public void clickCantLogIn() {
        LoginCommonEvents.clickButton(cantLogInLink);
    }

    public String getTittleCantLogIn() {
        return LoginCommonEvents.getTextContent(cantLogInTitle);
    }

    public void clickLogInWithGoogleBtn() {
        LoginCommonEvents.clickButton(logInWithGoogleBtn);
    }


    public void setIncorrectPasswordCredential() {
        String incorrectPassword = PropertyAccessor.getInstance().getIncorrectPassword();
        LoginCommonEvents.setInputField(passwordInputField, incorrectPassword);
    }

    public String getMsgPassError() {
        String msgError = (LoginCommonEvents.getTextContent(msgPassError)).substring(0, 42);
//        msgError.substring(0,10);
        System.out.print("MENSAJE ERROR: " + msgError);
        return msgError;
    }

}
