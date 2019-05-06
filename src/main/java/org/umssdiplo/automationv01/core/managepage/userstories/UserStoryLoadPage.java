package org.umssdiplo.automationv01.core.managepage.userstories;

import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public final class UserStoryLoadPage {

    public static UserStoryLogin loginPage() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to(PropertyAccessor.getInstance().getJiraUrl());
        return new UserStoryLogin();
    }

    public static UserStoryBacklog openBacklogProject() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to(PropertyAccessor.getInstance().getProjectUrl());
        return new UserStoryBacklog();
    }
}
