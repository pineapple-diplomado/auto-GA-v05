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

    @And("^Go to Editar$")
    public void clickThreePointIcon() throws Throwable {
        JiraLanzamiento.GoToEditar();
    }

    @And("^submit EditForm$")
    public void submitEditForm() throws Throwable {
        JiraLanzamiento.submitForm2();
    }

    @And("^Go to Eliminar$")
    public void goToEliminar() throws Throwable {
        JiraLanzamiento.GoToEliminar();
    }

    @And("^Go to Archive$")
    public void goToArchive() throws Throwable {
        JiraLanzamiento.GoToArchive();
    }

    @And("^Go to Publish$")
    public void GoToPublish() throws Throwable {
        JiraLanzamiento.GoToPublish();
    }

    @And("^Publish$")
    public void publish() throws Throwable {
        JiraLanzamiento.PublishRelease();
    }

    @And("^Go to Select Filter$")
    public void goToSelectFilter() throws Throwable {
        JiraLanzamiento.OpenFilter();
    }

    @And("^Select Publishes")
    public void selectPubliches() throws Throwable {
        JiraLanzamiento.SelectPublishes();
    }

    @And("^Select Archives$")
    public void selectArchives() throws Throwable {
        JiraLanzamiento.SelectArchives();
    }
}
