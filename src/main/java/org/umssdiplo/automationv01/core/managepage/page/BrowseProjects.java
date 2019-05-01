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

    @FindBy(xpath = "//button[.//text()='Create project']")
    private WebElement createProjectBtn;

    private static final String PATH_CREATE_PROJECT = "//div[@role='menu']/span[@tabindex='0']";

    public BrowseProjects() {
        CommonEvents.waitElementVisible(container);
    }

    public Backlog clickProjectLink(String project) {
        By by = By.xpath(String.format(PATH_CREATE_PROJECT, project));
        CommonEvents.clickButton(by);
        return new Backlog();
    }

    public Backlog openBacklogProject1() {
        LoadPage.backlogPage();
        return new Backlog();
    }
}
