package org.umssdiplo.automationv01.core.utils;

import org.umssdiplo.automationv01.core.Login.Login;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;

public final class LoadPage {
    public static Login loginPage() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to(PropertyAccessor.getInstance().getBaseUrl());
        return new Login();
    }
}
