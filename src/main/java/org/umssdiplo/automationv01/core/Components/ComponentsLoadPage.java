package org.umssdiplo.automationv01.core.Components;

import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public final class ComponentsLoadPage {
    public static Login loginPage() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to(PropertyAccessor.getInstance().getBaseUrl());
        return new Login();
    }

    public static Components componentsPage() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to("https://pineappleautomation.atlassian.net/projects/CP?selectedItem=com.atlassian.jira.jira-projects-plugin%3Acomponents-page");
        return new Components();
    }

    public static ComponentsLogin loginJiraPage(String jiraUrl) {
        ManageDriver.getInstance().getWebDriver().navigate().to(jiraUrl);
        return new ComponentsLogin();
    }

    public static ComponentsLogin loginJira() {
        ManageDriver.getInstance().getWebDriver()
                .navigate().to("https://pineappleautomation.atlassian.net/secure/RapidBoard.jspa?projectKey=CP&rapidView=2&view=planning.nodetail");
        return new ComponentsLogin();
    }
}
