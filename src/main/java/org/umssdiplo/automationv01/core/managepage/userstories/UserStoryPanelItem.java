package org.umssdiplo.automationv01.core.managepage.userstories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;

public class UserStoryPanelItem extends BasePage {

    @FindBy(id = "ghx-detail-view")
    private WebElement container;

    private static final String PATH_TITLE = "//h1[contains(text(),'%s')]";

    private static final String PATH_TITLE_DIV = "//h1[textarea(text(),'%s')]";

    private static final String PATH_STATUS = "//button[.//span[contains(text(),'To Do')]]";
    private static final String PATH_STATUS_IN_PROGRESS = "//span[@role='menuitem'][1]";
    private static final String PATH_STATUS_IN_PROGRESS_TEXT = "//button//span[contains(text(),'In Progress')]";

    private static final String PATH_DESCRIPTION = "//span[contains(text(),'Add a description...')]";
    private static final String PATH_DESCRIPTION_TEXT = "//div[contains(@contenteditable,'true')]";
    private static final String PATH_DESCRIPTION_SAVE = "//button[.//span[contains(text(),'Save')]]";
    private static final String PATH_DESCRIPTION_VALUE = "//p[contains(text(),'%s')]";

    private static final String PATH_COMMENT = "//input[contains(@placeholder,'Add a comment')]";
    private static final String PATH_COMMENT_TEXT = "//div[contains(@contenteditable,'true')]";
    private static final String PATH_COMMENT_SAVE = "//button[.//span[contains(text(),'Save')]]";
    private static final String PATH_COMMENT_VALUE = "//p[contains(text(),'%s')]";

    private static final String PATH_SHOW_MORE = "//button[.//span[contains(text(),'Show more')]]/..";
    private static final String PATH_TIME_LOGGED = "//span[contains(text(),'No time logged')]";
    private static final String PATH_TIME_LOGGED_TEXT = "//input[contains(@placeholder,'e.g. 3w 4d 12h')]";
    private static final String PATH_TIME_LOGGED_SAVE = "//button[.//span[contains(text(),'Save')]]";
    private static final String PATH_TIME_LOGGED_VALUE = "//span[contains(text(),'%s')]";

    private static final String PATH_LINK_BUTTON = "//button[.//span[contains(@aria-label,'Link issue')]]";
    private static final String PATH_LINK_FIELD = "//input[contains(@placeholder,'Search for issues')]";
    private static final String PATH_LINK_TEXT = "//select[@multiple]/following-sibling::div//input";
    private static final String PATH_LINK_ITEM = "//span[@role='menuitem']//span[contains(text(),'%s')]";
    private static final String PATH_LINK_SAVE = "//button[.//span[contains(text(),'Link')]]";
    private static final String PATH_LINK_VALUE = "//div[@tabindex]//div[contains(text(),'%s')]";

    private static final String PATH_SUBTASK_BUTTON = "//button[.//span[contains(@aria-label,'Create subtask')]]";
    private static final String PATH_SUBTASK_FIELD = "//input[contains(@placeholder,'What needs to be done?')]";
    private static final String PATH_SUBTASK_CREATE = "//button[.//span[contains(text(),'Create')]]";
    private static final String PATH_SUBTASK_VALUE = "//div[@tabindex]//div[contains(text(),'%s')]";


    @FindBy(id = "summary")
    private WebElement titleText;

    @FindBy(id = "create-issue-submit")
    private WebElement createButton;

    public UserStoryPanelItem() {
        UserStoryCommonEvents.waitElementVisible(container);
    }
/*
    public void fillText(String summary) {
        UserStoryCommonEvents.setInputField(summaryText, summary);
    }

    public void clickCreateDialogButton() {
        UserStoryCommonEvents.clickButton(createButton);
    }
*/

    public void clickOnTitle(String title, String storyName) {
        By by = By.xpath(String.format(PATH_TITLE, title));
        By by2 = By.xpath(String.format(PATH_TITLE_DIV, title));
        UserStoryCommonEvents.clickButton(by);

        UserStoryCommonEvents.setInputField(by2, storyName);

        UserStoryCommonEvents.pressEnterKey(by2);
    }

    public void clickOnStatus() {
        By by = By.xpath(PATH_STATUS);
        UserStoryCommonEvents.clickButton(by);
    }

    public void clickOnStatusInProgress() {
        By by = By.xpath(PATH_STATUS_IN_PROGRESS);
        UserStoryCommonEvents.clickButton(by);
    }

    public String getStatusText() {
        By by = By.xpath(PATH_STATUS_IN_PROGRESS_TEXT);
        return UserStoryCommonEvents.getTextContent(by);
    }

    public void clickOnDescription() {
        By by = By.xpath(PATH_DESCRIPTION);
        UserStoryCommonEvents.clickButton(by);
    }

    public void fillOnDescription(String text) {
        By by = By.xpath(PATH_DESCRIPTION_TEXT);
        UserStoryCommonEvents.setInputField(by, text);
    }

    public void clickOnSaveDescription() {
        By by = By.xpath(PATH_DESCRIPTION_SAVE);
        UserStoryCommonEvents.clickButton(by);
    }

    public String getDescriptionValue(String description) {
        By by = By.xpath(String.format(PATH_DESCRIPTION_VALUE, description));
        return UserStoryCommonEvents.getTextContent(by);
    }

    public void clickOnComment() {
        By by = By.xpath(PATH_COMMENT);
        UserStoryCommonEvents.clickButton(by);
    }

    public void fillOnComment(String text) {
        By by = By.xpath(PATH_COMMENT_TEXT);
        UserStoryCommonEvents.setInputField(by, text);
    }

    public void clickOnSaveComment() {
        By by = By.xpath(PATH_COMMENT_SAVE);
        UserStoryCommonEvents.clickButton(by);
    }

    public String getCommentValue(String comment) {
        By by = By.xpath(String.format(PATH_COMMENT_VALUE, comment));
        return UserStoryCommonEvents.getTextContent(by);
    }

    public void clickOnShowMore() {
        try {
            By by = By.xpath(PATH_SHOW_MORE);
            UserStoryCommonEvents.clickButton(by);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void clickOnTimeLogged() {
        By by = By.xpath(PATH_TIME_LOGGED);
        UserStoryCommonEvents.clickButton(by);
    }

    public void fillTimeLogged(String text) {
        By by = By.xpath(PATH_TIME_LOGGED_TEXT);
        UserStoryCommonEvents.setInputField(by, text);
    }

    public void clickOnSaveTimeLogged() {
        By by = By.xpath(PATH_TIME_LOGGED_SAVE);
        UserStoryCommonEvents.clickButton(by);
    }

    public String getTimeLoggedValue(String timeLogged) {
        By by = By.xpath(String.format(PATH_TIME_LOGGED_VALUE, timeLogged));
        return UserStoryCommonEvents.getTextContent(by);
    }

    public void clickOnLinkButton() {
        By by = By.xpath(PATH_LINK_BUTTON);
        UserStoryCommonEvents.clickButton(by);
    }

    public void clickOnSearchIssues() {
        By by = By.xpath(PATH_LINK_FIELD);
        UserStoryCommonEvents.clickButton(by);
    }

    public String getTextSelectedItem(String item) {
        By by = By.xpath(String.format(PATH_LINK_ITEM, item));
        return UserStoryCommonEvents.getTextContent(by);
    }

    public void clickOnSaveLink() {
        By by = By.xpath(PATH_LINK_SAVE);
        UserStoryCommonEvents.clickButton(by);
    }

    public void fillLinkItem(String textItem) {
        By by = By.xpath(String.format(PATH_LINK_TEXT));
        UserStoryCommonEvents.setInputField(by, textItem.trim());
    }

    public void clickEnterLinkItem() {
        By by = By.xpath(String.format(PATH_LINK_TEXT));
        UserStoryCommonEvents.pressEnterKey(by);
    }

    public String getLinkedValue(String linkedItem) {
        By by = By.xpath(String.format(PATH_LINK_VALUE, linkedItem));
        return UserStoryCommonEvents.getTextContent(by);
    }

    public void clickOnCreateSubTask() {
        By by = By.xpath(PATH_SUBTASK_BUTTON);
        UserStoryCommonEvents.clickButton(by);
    }

    public void clickSubTaskField() {
        By by = By.xpath(PATH_SUBTASK_FIELD);
        UserStoryCommonEvents.clickButton(by);
    }

    public void fillSubTaskField(String text) {
        By by = By.xpath(PATH_SUBTASK_FIELD);
        UserStoryCommonEvents.setInputField(by, text);
    }

    public void clickOnCreateSubTaskButton() {
        By by = By.xpath(PATH_SUBTASK_CREATE);
        UserStoryCommonEvents.clickButton(by);
    }

    public String getSubTaskValue(String subtask) {
        By by = By.xpath(String.format(PATH_SUBTASK_VALUE, subtask));
        return UserStoryCommonEvents.getTextContent(by);
    }
}
