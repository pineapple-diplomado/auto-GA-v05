package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.managepage.Pages.GoogleLoginForm;
import org.umssdiplo.automationv01.core.managepage.Pages.MyAccountDialog;
import org.umssdiplo.automationv01.core.managepage.Pages.RegisterForm;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionJira {
    private Login login;

    private MyAccountDialog myAccountDialog = new MyAccountDialog();

    private RegisterForm registerForm = new RegisterForm();

    private GoogleLoginForm googleLoginForm = new GoogleLoginForm();

    @Given("^'Jira' main page is loaded$")
    public void jiraPageIsLoadedInLoginForm() throws Throwable {
        login = LoadPage.loginPage();
    }

    @Given("^click on the 'Login' button on the main page$")
    public void clickOnTheLoginButtonOnTheMainPage() throws InterruptedException {
        login.clickLoginBtnMainPage();
    }

    @When("^set my credentials mail on 'Login' page$")
    public void setMyCredentialsMailOnLoginPage() throws Throwable {
        login.setEmailCredential();
    }

    @When("^click 'Continue' button in 'Login' page$")
    public void clickContinueButtonInLoginPage() throws InterruptedException {
        login.clickContinue();
    }

    @When("^set my credentials password on 'Login' page$")
    public void setMyCredentialsPasswordOnLoginPage() {
        login.setPasswordCredential();
    }

    @And("^click 'Log in' button in 'Login' page$")
    public void clickLogInButtonInLoginPage() throws InterruptedException {
        login.clickLogin();
    }

    @When("^click on the icon edit button of the email field$")
    public void clickOnTheIconEditButtonOfTheEmailField() throws InterruptedException {
        login.clickEditIconBtn();
    }


    @Then("^verify that you have logged in with the mail \"([^\"]*)\"$")
    public void verifyThatYouHaveLoggedInWithTheMail(String mailExpected) throws Throwable {
        String mailActual = myAccountDialog.getMail();
        Assert.assertEquals(mailActual, mailExpected);

        //throw new PendingException();
    }

    @Then("^verify that you have logged in with the user \"([^\"]*)\"$")
    public void verifyThatYouHaveLoggedInWithTheUser(String userExpected) throws Throwable {
        String userActual = myAccountDialog.getName();
        Assert.assertEquals(userActual, userExpected);

        //throw new PendingException();
    }


    @When("^set mail: dsds@xyz.com$")
    public void setMailDsdsXyzCom() {
        login.setEmailCredentialNotExist();
    }

    @Then("^Verify that the name of the page should be \"([^\"]*)\"$")
    public void verifyThatTheNameOfThePageShouldBe(String textExpected) throws Throwable {
        String textActual = registerForm.getTittleNewAccount();
        Assert.assertEquals(textActual, textExpected);
    }

    @Then("^Validate the field is displayed$")
    public void validateInputField() throws Throwable {
        Assert.assertTrue(login.validateInputIsDisplayed(), "fail");
    }

    @Then("^Validate the mail is displayed as span$")
    public void validateTheMailIsDisplayedAsSpan() {
        Assert.assertTrue(login.validateSpanIsDisplayed());

    }

    /*
        Segunda parte
     */

    @Then("^Validate the span icon is displayed in email field$")
    public void validateTheSpanIconIsDisplayed() throws InterruptedException {
        Assert.assertTrue(login.validateSpanIconIsDisplayed());
    }

    @When("click Can't log in link in Login page")
    public void clickCanTLogInLinkInLoginPage() {
        login.clickCantLogIn();
    }

    @Then("^Verify that the title of the Can't log in page is \"([^\"]*)\"$")
    public void verifyThatTheTitleOfTheCanTLogInPageIs(String textCantLogInExpected) throws Throwable {
        String textActual = login.getTittleCantLogIn();
        Assert.assertEquals(textActual, textCantLogInExpected);
    }

    @And("^click on Log in with Google button$")
    public void clickOnLogInWithGoogleButton() {
        login.clickLogInWithGoogleBtn();
    }


    @And("^set my credential email on login google page$")
    public void setMyCredentialEmailOnLoginGooglePage() {
        googleLoginForm.setEmailGoogleCredential();
    }


    @And("^set my credentials incorrect password on 'Login' page$")
    public void setMyCredentialsIncorrectPasswordOnLoginPage() {
        login.setIncorrectPasswordCredential();
    }

    @Then("^verify that the error message that is displayed is \"([^\"]*)\"$")
    public void verifyThatTheErrorMessageThatIsDisplayedIs(String textExpected) throws Throwable {
        String textActual = login.getMsgPassError();
        Assert.assertEquals(textActual, textExpected);
    }


    @And("^click on the 'Siguiente' button after set email on login google page$")
    public void clickOnTheSiguienteButtonAfterSetEmailOnLoginGooglePage() {
        googleLoginForm.clickSiguienteEmailBtn();
    }

    @And("^set my credential password on login google page$")
    public void setMyCredentialPasswordOnLoginGooglePage() {
        googleLoginForm.setPassGoogleCredential();
    }

    @And("^click on the 'Siguiente' button after set password on login google page$")
    public void clickOnTheSiguienteButtonAfterSetPasswordOnLoginGooglePage() {
        googleLoginForm.clickSiguientePassBtn();
    }
}
