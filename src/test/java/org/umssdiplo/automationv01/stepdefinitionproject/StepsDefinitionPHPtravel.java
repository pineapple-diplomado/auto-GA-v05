package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.Components.Components;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionPHPtravel {
    private Login login;
    private Components components;

    @Given("^'PHP travel' page is loaded$")
    public void phpTravelPageIsLoaded() throws Throwable {
        login = LoadPage.loginPage();
    }

    @And("^set my credentials on 'Login' page$")
    public void setMyCredentialsOnLoginPage() throws Throwable {
        login.setCredentials();
    }

    @And("^set \"([^\"]*)\" email field on 'Login' page$")
    public void setEmailFieldOnLoginPage(String email) throws Throwable {
        login.setEmail(email);
    }

    @And("^set \"([^\"]*)\" password field on 'Login' page$")
    public void setPasswordFieldOnLoginPage(String password) throws Throwable {
        login.setPassword(password);
    }

    @Given("^'Jira' page is loaded$")
    public void jiraPageIsLoaded() throws Throwable{
        login = LoadPage.loginPage();
    }

    @And("^set \"([^\"]*)\" in email field on 'Login' page$")
    public void setInEmailFieldOnLoginPage(String arg0) throws Throwable {
        login.setEmail(arg0);
    }

    @And("^click 'Continue' button$")
    public void clickContinueButton() throws Throwable{
        login.clickContinueButton();
    }

    @And("^click 'Log in' button$")
    public void clickLogInButton() throws Throwable{
//        components = LoadPage.componentsPage();
        components = login.login();
    }

    @And("^'click Component' of the main menu$")
    public void clickComponentOfTheMainMenu() {
        components.redirect();
    }
}
