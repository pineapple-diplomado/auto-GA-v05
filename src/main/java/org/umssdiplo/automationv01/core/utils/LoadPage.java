package org.umssdiplo.automationv01.core.utils;

import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.page.Backlog;
import org.umssdiplo.automationv01.core.managepage.Login.Login;

public final class LoadPage {
    public static Login loginPage() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to(PropertyAccessor.getInstance().getBaseUrl());
        return new Login();
    }

    public static Login loginPage(String url) {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to(url);
        return new Login();
    }

    public static Backlog backlogPage() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to(PropertyAccessor.getInstance().getProjectUrl());
        return new Backlog();
    }
}
