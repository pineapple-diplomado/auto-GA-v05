package org.umssdiplo.automationv01.core.managepage.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class DialogItemCreation extends BasePage {

    @FindBy(xpath = "//div[@id='create-issue-dialog']")
    private WebElement container;

    @FindBy(id = "summary")
    private WebElement summaryText;

    @FindBy(id = "create-issue-submit")
    private WebElement createButton;

    public DialogItemCreation() {
        CommonEvents.waitElementVisible(container);
    }

    public void fillText(String summary) {
        CommonEvents.setInputField(summaryText, summary);
    }

    public void clickCreateDialogButton() {
        CommonEvents.clickButton(createButton);
    }
}
