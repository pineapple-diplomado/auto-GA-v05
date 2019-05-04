package org.umssdiplo.automationv01.core.managepage.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class BrowseProjects extends BasePage {

    //@FindBy(xpath = "//div[@data-test-id='directory-base.content.table.container']")
    @FindBy(xpath = "//div[@id='page']")
    private WebElement container;

    private static final String PATH_CREATE_PROJECT_BUTTON = "//button[.//text()='Create project']";
    private static final String PATH_CREATE_PROJECT_OPTION = "//div[@role='menu']/span[@tabindex='0']";
    private static final String PATH_PROJECT_NAME = "//input[contains(@placeholder,'Enter a project name')]";
    private static final String PATH_PROJECT_CREATE_BUTTON = "//button[.//span[contains(text(),'Create')]]";
    private static final String PATH_PROJECT_LINK = "//a[.//span[contains(text(),'%s')]]";

    public BrowseProjects() {
        CommonEvents.waitElementVisible(container);
    }

    public Backlog openBacklogProject(String projectUrl) {
        LoadPage.openBacklogProject(projectUrl);
        return new Backlog();
    }

    public void clickCreateProject() {
        By by = By.xpath(PATH_CREATE_PROJECT_BUTTON);
        CommonEvents.clickButton(by);
    }

    public void selectClassicProject() {
        By by = By.xpath(PATH_CREATE_PROJECT_OPTION);
        CommonEvents.clickButton(by);
    }

    public void fillProjectName(String projectName) {
        By by = By.xpath(PATH_PROJECT_NAME);
        CommonEvents.setInputField(by, projectName);
    }

    public void hoverCreateProjectButton() {
        By by = By.xpath(PATH_PROJECT_CREATE_BUTTON);
        CommonEvents.hoverOn(by);
    }

    public void clickCreateProjectButton() {
        By by = By.xpath(PATH_PROJECT_CREATE_BUTTON);
        CommonEvents.clickButton(by);
    }

    public String getProjectUrl(String projectName) {
        By by = By.xpath(String.format(PATH_PROJECT_LINK, projectName));
        return CommonEvents.getAttribute("href", by);
    }
}
