package org.umssdiplo.automationv01.core.managepage.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class Backlog extends BasePage {

    /*
    @FindBy(xpath = "//div[contains(@class,'ghx-backlog-container ghx-open')]")
    private WebElement container;
    */

    @FindBy(xpath = "//div[@data-test-id='GlobalNavigation']")
    private WebElement container;

    @FindBy(xpath = "//button[@id='createGlobalItem']")
    private WebElement createItemBtn;


    public Backlog() {
        CommonEvents.waitElementVisible(container);
    }

    public DialogItemCreation clickCreateIssueBtn() {
        CommonEvents.clickButton(createItemBtn);
        return new DialogItemCreation();
    }
}
