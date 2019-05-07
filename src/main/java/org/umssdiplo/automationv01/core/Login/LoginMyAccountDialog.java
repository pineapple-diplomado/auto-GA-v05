package org.umssdiplo.automationv01.core.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;

public class LoginMyAccountDialog extends BasePage {
    @FindBy(xpath = "//div[@class='sc-jKJlTe ffxovy']")
    private WebElement email;

    @FindBy(xpath = "//div[@class=\"sc-ckVGcZ jVMSJa\"]")
    private WebElement name;


    @FindBy(xpath = "//div/button[@class=\"sc-kgoBCf bPIvkK\"][3]")
    private WebElement logoutBtn;


    public String getMail() {
        String mailText = LoginCommonEvents.getTextContent(email);
        return mailText;
    }

    public String getName() {
        String nameText = LoginCommonEvents.getTextContent(name);
        return nameText;
    }


    public void logoutBtn() {
        LoginCommonEvents.clickButton(logoutBtn);
    }
}
