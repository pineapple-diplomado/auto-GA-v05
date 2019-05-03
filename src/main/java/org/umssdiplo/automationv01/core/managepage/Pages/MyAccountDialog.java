package org.umssdiplo.automationv01.core.managepage.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class MyAccountDialog extends BasePage {
    @FindBy(xpath = "//div[@class='sc-jKJlTe ffxovy']")
    private WebElement email;

    @FindBy(xpath = "//div[@class=\"sc-ckVGcZ jVMSJa\"]")
    private WebElement name;


//    public MyAccountDialog() {
//        CommonEvents.waitDilogVisible(container);
//    }

    public String getMail() {
        String mailText = CommonEvents.getTextContent(email);
        return mailText;
    }

    public String getName() {
        String nameText = CommonEvents.getTextContent(name);
        return nameText;
    }
}
