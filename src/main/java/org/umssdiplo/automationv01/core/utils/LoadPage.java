package org.umssdiplo.automationv01.core.utils;

import org.openqa.selenium.WebDriver;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.Login.Login;

public final class LoadPage {
    public static Login loginPage() {
        WebDriver webDriver = ManageDriver.getInstance().getWebDriver();
        webDriver.navigate().to(PropertyAccessor.getInstance().getBaseUrl());
        return new Login();
    }
}
