package org.umssdiplo.automationv01.core.managepage.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public class GoogleLoginForm extends BasePage {

    @FindBy(xpath = "//input[@id=\'identifierId\']")
    private WebElement emailGoogleInputField;

    @FindBy(xpath = "//div[@id='identifierNext']/content/span")
    private WebElement siguienteEmailBtn;

    @FindBy(xpath = "//*[@id=\'password\']/div[1]/div/div[1]/input")
    private WebElement passGoogleInputField;

    @FindBy(id = "passwordNext")
    private WebElement siguientePassBtn;


    public void setEmailGoogleCredential() {
        String googleUsername = PropertyAccessor.getInstance().getUserGoogle();
        CommonEvents.setInputField(emailGoogleInputField, googleUsername);
    }


    public void clickSiguienteEmailBtn() {
        CommonEvents.clickButton(siguienteEmailBtn);
    }

    public void setPassGoogleCredential() {
        String googlePass = PropertyAccessor.getInstance().getPassGoogle();
        CommonEvents.setInputField(passGoogleInputField, googlePass);
    }

    public void clickSiguientePassBtn() {
        CommonEvents.clickButton(siguientePassBtn);
    }
}
