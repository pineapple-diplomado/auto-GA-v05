package org.umssdiplo.automationv01.core.projects;

import org.openqa.selenium.WebDriver;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public final class ProjectLoadPage {
    public static ProjectLogin loginPage() {
        WebDriver webDriver = ManageDriver.getInstance().getWebDriver();
        webDriver.navigate().to("https://pineappleautomation.atlassian.net");
        return new ProjectLogin();
    }
}
