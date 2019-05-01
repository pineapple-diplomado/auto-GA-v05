package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.managepage.PagesJavierZapata.HomePage;
import org.umssdiplo.automationv01.core.managepage.PagesJavierZapata.JiraLoginPage;
import org.umssdiplo.automationv01.core.utils.LoadPageJavierZapata;

public class StepsDefinitionJavierZapata {
    private Login login;
    private JiraLoginPage jiraLoginPage;
    private HomePage homePage;



    @Given("^'JiraLoginPage' page is loaded$")
    public void jirapagePageIsLoaded() {
        jiraLoginPage = LoadPageJavierZapata.homePage();

    }

    @And("^set my credentials on 'JiraLoginPage' page$")
    public void setMyCredentialsOnAtlassianPage() {
        homePage = jiraLoginPage.setCredentials();
    }

    @And("^Click \"([^\"]*)\" proyecto on HomePage page$")
    public void clickProyectoOnHomePagePage(String nombreProyecto) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        homePage.seleccionarProyecto(nombreProyecto);
    }
}
