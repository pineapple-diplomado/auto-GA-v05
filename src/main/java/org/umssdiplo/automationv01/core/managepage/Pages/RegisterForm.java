package org.umssdiplo.automationv01.core.managepage.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class RegisterForm extends BasePage {

    @FindBy(xpath = "//header[@class='sc-iwsKbI eeKkun']/div/h1")
    private WebElement h1Tittle;

    public String getTittleNewAccount() {
        //Thread.sleep(5000);
        String tittle = CommonEvents.getTextContent(h1Tittle);
        //System.out.println(tittle);
        return tittle.trim();
    }
}
