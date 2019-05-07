package org.umssdiplo.automationv01.core.managepage.userstories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;

public class UserStoryDialogItemCreation extends BasePage {

    @FindBy(xpath = "//div[@id='create-issue-dialog']")
    private WebElement container;

    @FindBy(id = "summary")
    private WebElement summaryText;

    @FindBy(id = "create-issue-submit")
    private WebElement createButton;

    public UserStoryDialogItemCreation() {
        UserStoryCommonEvents.waitElementVisible(container);
    }

    public void fillText(String summary) {
        UserStoryCommonEvents.setInputField(summaryText, summary);
    }

    public void clickCreateDialogButton() {
        UserStoryCommonEvents.clickButton(createButton);
    }
}
