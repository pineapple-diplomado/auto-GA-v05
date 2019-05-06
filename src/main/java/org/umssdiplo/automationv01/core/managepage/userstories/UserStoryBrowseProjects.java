package org.umssdiplo.automationv01.core.managepage.userstories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;

public class UserStoryBrowseProjects extends BasePage {

    //@FindBy(xpath = "//div[@data-test-id='directory-base.content.table.container']")
    @FindBy(xpath = "//div[@id='userstories']")
    private WebElement container;

    private static final String PATH_CREATE_PROJECT_BUTTON = "//button[.//text()='Create project']";
    private static final String PATH_CREATE_PROJECT_OPTION = "//div[@role='menu']/span[@tabindex='0']";
    private static final String PATH_PROJECT_NAME = "//input[contains(@placeholder,'Enter a project name')]";
    private static final String PATH_PROJECT_CREATE_BUTTON = "//button[.//span[contains(text(),'Create')]]";
    private static final String PATH_PROJECT_LINK = "//a[.//span[contains(text(),'%s')]]";

    public UserStoryBrowseProjects() {
        UserStoryCommonEvents.waitElementVisible(container);
    }

    public UserStoryBacklog openBacklogProject(String projectUrl) {
        UserStoryLoadPage.openBacklogProject();
        return new UserStoryBacklog();
    }

    public void clickCreateProject() {
        By by = By.xpath(PATH_CREATE_PROJECT_BUTTON);
        UserStoryCommonEvents.clickButton(by);
    }

    public void selectClassicProject() {
        By by = By.xpath(PATH_CREATE_PROJECT_OPTION);
        UserStoryCommonEvents.clickButton(by);
    }

    public void fillProjectName(String projectName) {
        By by = By.xpath(PATH_PROJECT_NAME);
        UserStoryCommonEvents.setInputField(by, projectName);
    }

    public void hoverCreateProjectButton() {
        By by = By.xpath(PATH_PROJECT_CREATE_BUTTON);
        UserStoryCommonEvents.hoverOn(by);
    }

    public void clickCreateProjectButton() {
        By by = By.xpath(PATH_PROJECT_CREATE_BUTTON);
        UserStoryCommonEvents.clickButton(by);
    }

    public String getProjectUrl(String projectName) {
        By by = By.xpath(String.format(PATH_PROJECT_LINK, projectName));
        return UserStoryCommonEvents.getAttribute("href", by);
    }
}
