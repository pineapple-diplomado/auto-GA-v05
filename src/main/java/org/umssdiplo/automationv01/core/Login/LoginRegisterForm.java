package org.umssdiplo.automationv01.core.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;

public class LoginRegisterForm extends BasePage {

    @FindBy(xpath = "//header[@class='sc-iwsKbI eeKkun']/div/h1")
    private WebElement h1Tittle;

    public String getTittleNewAccount() {
        //Thread.sleep(5000);
        String tittle = LoginCommonEvents.getTextContent(h1Tittle);
        //System.out.println(tittle);
        return tittle.trim();
    }
}
