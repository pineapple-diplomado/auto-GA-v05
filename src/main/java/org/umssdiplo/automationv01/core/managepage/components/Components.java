package org.umssdiplo.automationv01.core.managepage.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class Components extends BasePage {
    @FindBy(xpath = "//a[@href=\"/projects/JAG?selectedItem=com.atlassian.jira.jira-projects-plugin:components-page\"]")
    private WebElement componentsOption;

    public void redirect() {
        CommonEvents.jsClickElement(componentsOption);
    }
}
