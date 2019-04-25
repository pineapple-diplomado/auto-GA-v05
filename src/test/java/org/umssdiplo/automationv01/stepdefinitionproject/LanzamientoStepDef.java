package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.umssdiplo.automationv01.core.managepage.JiraLanzamiento.Lanzamiento;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class LanzamientoStepDef {

    private Lanzamiento JiraLanzamiento;

    @Given("^'Jira' page is loaded$")
    public void jiraPageIsLoaded() throws Throwable {
        JiraLanzamiento = LoadPage.jiraPage();
    }

    @And("^start login by email$")
    public void startLoginByEmail() throws Throwable {
        JiraLanzamiento.Authentication();
    }


    @And("^go to lanzamiento$")
    public void goToLanzamiento() throws Throwable {
        JiraLanzamiento.goToReleasePage();
    }

    @And("^open new Release Form$")
    public void openNewReleaseForm() throws Throwable {
        JiraLanzamiento.openNewReleaseForm();
    }

    @And("^submit Form$")
    public void submitForm() throws Throwable {
        JiraLanzamiento.submitForm();
    }
}
