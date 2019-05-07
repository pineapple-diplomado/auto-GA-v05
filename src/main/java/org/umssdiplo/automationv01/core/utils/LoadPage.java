package org.umssdiplo.automationv01.core.utils;

import org.openqa.selenium.WebDriver;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.JiraLanzamiento.Lanzamiento;
import org.umssdiplo.automationv01.core.managepage.Login.Login;

public final class LoadPage {

    public static Login loginPage() {
        WebDriver webDriver = ManageDriver.getInstance().getWebDriver();
        webDriver.navigate().to(PropertyAccessor.getInstance().getBaseUrl());
        return new Login();
    }

    public static Login loginJiraPage(String jiraUrl) {
        ManageDriver.getInstance().getWebDriver().navigate().to(jiraUrl);
        return new Login();
    }

    public static Lanzamiento jiraPage() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to(PropertyAccessor.getInstance().getBaseJiraUrl());
        return new Lanzamiento();
    }
}
