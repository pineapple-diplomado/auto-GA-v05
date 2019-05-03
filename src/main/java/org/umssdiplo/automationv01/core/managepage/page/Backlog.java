package org.umssdiplo.automationv01.core.managepage.page;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class Backlog extends BasePage {

    @FindBy(xpath = "//div[@data-test-id='GlobalNavigation']")
    private WebElement container;

    @FindBy(xpath = "//button[@id='createGlobalItem']")
    private WebElement createItemBtn;

    private static final String PATH_STORY_CREATED = "//div[contains(@class,'js-issue-list ghx-issues ghx-has-issues')]/div[contains(@class,'js-issue')][1]//span[@class='ghx-inner']";
    private static final String PATH_STORY_ITEM = "//div[contains(@class,'js-issue-list ghx-issues ghx-has-issues')]/div[.//span[contains(text(),'%s')]]";

    public Backlog() {
        CommonEvents.waitElementVisible(container);
    }

    public DialogItemCreation clickCreateIssueBtn() {
        CommonEvents.clickButton(createItemBtn);
        return new DialogItemCreation();
    }

    public String getFirstStory() {
        By by = By.xpath(PATH_STORY_CREATED);
        return CommonEvents.getTextContent(by);
    }

    public PanelItem clicOnItem(String storyName) {
        By by = By.xpath(String.format(PATH_STORY_ITEM, storyName));
        CommonEvents.clickButton(by);
        return new PanelItem();
    }
}
