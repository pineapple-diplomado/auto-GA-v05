package org.umssdiplo.automationv01.core.managepage.projectPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.components.Components;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

public class ProjectPage extends BasePage {
    @FindBy(xpath = "//p[.//text()='JaggerProject']")
    private WebElement projectElement;

    public Components openProject() {
        CommonEvents.clickButton(projectElement);
        CommonEvents.forceWait(4000);
        return new Components();
    }
}
