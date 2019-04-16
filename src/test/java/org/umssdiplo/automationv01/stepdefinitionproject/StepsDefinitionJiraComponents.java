package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import org.umssdiplo.automationv01.core.managepage.components.Components;

public class StepsDefinitionJiraComponents {
    private Components components;

    @And("^'click Component option' of the main menu$")
    public void clickComponentOptionOfTheMainMenu() {
        components.redirect();
    }
}
