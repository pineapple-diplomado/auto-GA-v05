package org.umssdiplo.automationv01.core.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import javax.xml.xpath.XPath;

public class ProjectManagement extends BasePage {
    public ProjectManagement() {
    }

    public void clickCreateProject(String createProjectButton) {
        ProjectCommon.waitFor(3000);
        By by = By.xpath("//button[./span/span[.='" + createProjectButton + "']]");
        ProjectCommon.clickButton(by);
    }
}
