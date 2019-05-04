package org.umssdiplo.automationv01.core.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ProjectManagement extends BasePage {
    @FindBy(xpath = "//*[@class=\"sc-EHOje dCmFoj\"]")
    private WebElement createProject;

    public ProjectManagement() {
    }

    public void clickCreateProject() {
        CommonEvents.clickButton(this.createProject);
    }
}
