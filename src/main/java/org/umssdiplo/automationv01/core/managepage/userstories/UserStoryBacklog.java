package org.umssdiplo.automationv01.core.managepage.userstories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;

public class UserStoryBacklog extends BasePage {

    @FindBy(xpath = "//div[@data-test-id='GlobalNavigation']")
    private WebElement container;

    @FindBy(xpath = "//button[@id='createGlobalItem']")
    private WebElement createItemBtn;

    private static final String PATH_STORY_CREATED = "//div[contains(@class,'js-issue-list ghx-issues ghx-has-issues')]/div[contains(@class,'js-issue')][1]//span[@class='ghx-inner']";
    private static final String PATH_STORY_ITEM = "//div[contains(@class,'js-issue-list ghx-issues ghx-has-issues')]/div[.//span[contains(text(),'%s')]]";

    public UserStoryBacklog() {
        UserStoryCommonEvents.waitElementVisible(container);
    }

    public UserStoryDialogItemCreation clickCreateIssueBtn() {
        UserStoryCommonEvents.clickButton(createItemBtn);
        return new UserStoryDialogItemCreation();
    }

    public String getFirstStory() {
        By by = By.xpath(PATH_STORY_CREATED);
        return UserStoryCommonEvents.getTextContent(by);
    }

    public UserStoryPanelItem clicOnItem(String storyName) {
        By by = By.xpath(String.format(PATH_STORY_ITEM, storyName));
        UserStoryCommonEvents.clickButton(by);
        return new UserStoryPanelItem();
    }
}
