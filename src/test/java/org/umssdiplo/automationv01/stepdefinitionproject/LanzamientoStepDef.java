package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.umssdiplo.automationv01.core.managepage.JiraLanzamiento.Lanzamiento;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class LanzamientoStepDef {

    private Lanzamiento JiraLanzamiento;
    String firstVersion = "version 2";
    String firstVersionEdit = "version 2.1";

    String secondVersion = "version-_?";
    String secondVersionEdit = "version 3.1";
    String secondVersionComment = "test comment version 3";
    String secondVersionEditComment = "test comment version 3.1";

    @Given("^er 'Jira' lanzamiento page is loaded$")
    public void jiraPageIsLoaded() throws Throwable {
        JiraLanzamiento = LoadPage.jiraPage();
    }

    @And("^er start login by email$")
    public void startLoginByEmail() throws Throwable {
        JiraLanzamiento.Authentication();
    }


    @And("^er go to lanzamiento$")
    public void goToLanzamiento() throws Throwable {
        JiraLanzamiento.goToReleasePage();
    }

    @And("^er open new Release Form$")
    public void openNewReleaseForm() throws Throwable {
        JiraLanzamiento.openNewReleaseForm();
    }

    @And("^er submit Form$")
    public void submitForm() throws Throwable {

        JiraLanzamiento.submitForm(firstVersion, null);
    }

    @And("^er Go to Editar$")
    public void clickThreePointIcon() throws Throwable {
        JiraLanzamiento.GoToEditar();
    }

    @And("^er submit EditForm$")
    public void submitEditForm() throws Throwable {
        JiraLanzamiento.submitForm(firstVersionEdit, null);
    }

    @And("^er Go to Eliminar$")
    public void goToEliminar() throws Throwable {
        JiraLanzamiento.GoToEliminar();
    }

    @And("^er Go to Archive$")
    public void goToArchive() throws Throwable {
        JiraLanzamiento.GoToArchive();
    }

    @And("^er Go to Publish$")
    public void GoToPublish() throws Throwable {
        JiraLanzamiento.GoToPublish();
    }

    @And("^er Publish$")
    public void publish() throws Throwable {
        JiraLanzamiento.PublishRelease();
    }

    @And("^er Go to Select Filter$")
    public void goToSelectFilter() throws Throwable {
        JiraLanzamiento.OpenFilter();
    }

    @And("^er Select Publishes")
    public void selectPubliches() throws Throwable {
        JiraLanzamiento.SelectPublishes();
    }

    @And("^er Select Archives$")
    public void selectArchives() throws Throwable {
        JiraLanzamiento.SelectArchives();
    }

    @And("^er submit Form with comment$")
    public void submitFormWithComment() throws Throwable {
        JiraLanzamiento.submitForm(firstVersion, secondVersionComment);
    }

    @And("^er submit EditForm with comment$")
    public void submitEditFormWithComment() throws Throwable {
        JiraLanzamiento.submitForm(firstVersionEdit, secondVersionEditComment);
    }

    @And("^er submit Form with especial chars in title$")
    public void submitFormWithEspecialCharsInTitle() throws Throwable {
        JiraLanzamiento.submitForm(secondVersion, null);
    }
}
