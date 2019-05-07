package org.umssdiplo.automationv01.core.utils;

import org.umssdiplo.automationv01.core.Login.LoginLogin;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;

public final class LoginLoadPage {
    public static LoginLogin loginPage() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to(PropertyAccessor.getInstance().getBaseUrl());
        return new LoginLogin();
    }
}
