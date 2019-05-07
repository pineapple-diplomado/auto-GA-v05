package org.umssdiplo.automationv01.core.Tasks;

import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public final class TasksLoadPageJavierZapata {
    public static Login loginPage() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to(PropertyAccessor.getInstance().getBaseUrl());
        return new Login();
    }

    public static TasksJiraLoginPage homePage() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to("https://pineappleautomation.atlassian.net/secure/RapidBoard.jspa?rapidView=4&" +
                "projectKey=TAS&view=planning.nodetail&selectedIssue=TAS-1");
        return new TasksJiraLoginPage();
    }

    public static TasksBackLogPage homePage2() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to("https://pineappleautomation.atlassian.net/secure/RapidBoard.jspa?rapidView=11&" +
                "projectKey=TAS&view=planning.nodetail&selectedIssue=TAS-1");
        return new TasksBackLogPage();
    }

    public static TasksBackLogPage loadBackLog() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to("https://pineappleautomation.atlassian.net/secure/RapidBoard.jspa?rapidView=11&" +
                "projectKey=TAS&view=planning.nodetail&selectedIssue=TAS-1");
        return new TasksBackLogPage();
    }
}
