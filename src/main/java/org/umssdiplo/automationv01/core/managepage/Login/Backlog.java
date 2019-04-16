package org.umssdiplo.automationv01.core.managepage.Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class Backlog extends BasePage {

    @FindBy(xpath = "//*[@id=\"ghx-content-group\"]/div[2]/div[3]/div[2]/div[5]/div[1]/button")
    private WebElement createIssueBtn;

    public void clickCreateIssueBtn() {
        CommonEvents.clickButton(createIssueBtn);
    }
}
