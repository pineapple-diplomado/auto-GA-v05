package org.umssdiplo.automationv01.core.managepage.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class PanelItem extends BasePage {

    @FindBy(id = "ghx-detail-view")
    private WebElement container;

    private static final String PATH_TITLE = "//h1[contains(text(),'%s')]";

    private static final String PATH_TITLE_DIV = "//h1[textarea(text(),'%s')]";

    private static final String PATH_STATUS = "//button[.//span[contains(text(),'To Do')]]";
    private static final String PATH_STATUS_IN_PROGRESS = "//span[@role='menuitem'][1]";

    private static final String PATH_DESCRIPTION = "//span[contains(text(),'Add a description...')]";
    private static final String PATH_DESCRIPTION_TEXT = "//div[contains(@contenteditable,'true')]";
    private static final String PATH_DESCRIPTION_SAVE = "//button[.//span[contains(text(),'Save')]]";

    private static final String PATH_COMMENT = "//input[contains(@placeholder,'Add a comment')]";
    private static final String PATH_COMMENT_TEXT = "//div[contains(@contenteditable,'true')]";
    private static final String PATH_COMMENT_SAVE = "//button[.//span[contains(text(),'Save')]]";

    @FindBy(id = "summary")
    private WebElement titleText;

    @FindBy(id = "create-issue-submit")
    private WebElement createButton;

    public PanelItem() {
        CommonEvents.waitElementVisible(container);
    }
/*
    public void fillText(String summary) {
        CommonEvents.setInputField(summaryText, summary);
    }

    public void clickCreateDialogButton() {
        CommonEvents.clickButton(createButton);
    }
*/

    public void clickOnTitle(String title, String storyName) {
        By by = By.xpath(String.format(PATH_TITLE, title));
        By by2 = By.xpath(String.format(PATH_TITLE_DIV, title));
        CommonEvents.clickButton(by);

        CommonEvents.setInputField(by2, storyName);

        CommonEvents.pressEnterKey(by2);
    }

    public void clickOnStatus() {
        By by = By.xpath(PATH_STATUS);
        CommonEvents.clickButton(by);
    }

    public void clickOnStatusInProgress() {
        By by = By.xpath(PATH_STATUS_IN_PROGRESS);
        CommonEvents.clickButton(by);
    }

    public void clickOnDescription() {
        By by = By.xpath(PATH_DESCRIPTION);
        CommonEvents.clickButton(by);
    }

    public void fillOnDescription(String text) {
        By by = By.xpath(PATH_DESCRIPTION_TEXT);
        CommonEvents.setInputField(by, text);
    }

    public void clickOnSaveDescription() {
        By by = By.xpath(PATH_DESCRIPTION_SAVE);
        CommonEvents.clickButton(by);
    }

    public void clickOnComment() {
        By by = By.xpath(PATH_COMMENT);
        CommonEvents.clickButton(by);
    }

    public void fillOnComment(String text) {
        By by = By.xpath(PATH_COMMENT_TEXT);
        CommonEvents.setInputField(by, text);
    }

    public void clickOnSaveComment() {
        By by = By.xpath(PATH_COMMENT_SAVE);
        CommonEvents.clickButton(by);
    }

/*
    public void fillTitle(String storyName) {
        By by = By.xpath(String.format(PATH_TITLE, title));
        CommonEvents.clickButton(by);
    }*/
}
