package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.Login.Login;
import org.umssdiplo.automationv01.core.Login.LoginGoogleForm;
import org.umssdiplo.automationv01.core.Login.LoginMyAccountDialog;
import org.umssdiplo.automationv01.core.Login.LoginRegisterForm;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class LoginStepsDefinition {
    private Login login;

    private LoginMyAccountDialog loginMyAccountDialog = new LoginMyAccountDialog();

    private LoginRegisterForm loginRegisterForm = new LoginRegisterForm();

    private LoginGoogleForm loginGoogleForm = new LoginGoogleForm();

    @Given("^IZ 'Jira' main page is loaded$")
    public void jiraPageIsLoadedInLoginForm() throws Throwable {
        login = LoadPage.loginPage();
    }

    @Given("^IZ click on the 'Login' button on the main page$")
    public void clickOnTheLoginButtonOnTheMainPage() throws InterruptedException {
        login.clickLoginBtnMainPage();
    }

    @When("^IZ set my credentials mail on 'Login' page$")
    public void setMyCredentialsMailOnLoginPage() throws Throwable {
        login.setEmailCredential();
    }

    @When("^IZ click 'Continue' button in 'Login' page$")
    public void clickContinueButtonInLoginPage() throws InterruptedException {
        login.clickContinue();
    }

    @When("^IZ set my credentials password on 'Login' page$")
    public void setMyCredentialsPasswordOnLoginPage() {
        login.setPasswordCredential();
    }

    @When("^IZ click 'Log in' button in 'Login' page$")
    public void clickLogInButtonInLoginPage() throws InterruptedException {
        login.clickLogin();
    }

    @When("^IZ click on the icon edit button of the email field$")
    public void clickOnTheIconEditButtonOfTheEmailField() throws InterruptedException {
        login.clickEditIconBtn();
    }


    @Then("^IZ verify that you have logged in with the mail \"([^\"]*)\"$")
    public void verifyThatYouHaveLoggedInWithTheMail(String mailExpected) throws Throwable {
        String mailActual = loginMyAccountDialog.getMail();
        Assert.assertEquals(mailActual, mailExpected);
    }

    @Then("^IZ verify that you have logged in with the user \"([^\"]*)\"$")
    public void verifyThatYouHaveLoggedInWithTheUser(String userExpected) throws Throwable {
        String userActual = loginMyAccountDialog.getName();
        Assert.assertEquals(userActual, userExpected);
    }


    @When("^IZ set mail: dsds@xyz.com$")
    public void setMailDsdsXyzCom() {
        login.setEmailCredentialNotExist();
    }

    @Then("^IZ Verify that the name of the page should be \"([^\"]*)\"$")
    public void verifyThatTheNameOfThePageShouldBe(String textExpected) throws Throwable {
        String textActual = loginRegisterForm.getTittleNewAccount();
        Assert.assertEquals(textActual, textExpected);
    }

    @Then("^IZ Validate the field is displayed$")
    public void validateInputField() throws Throwable {
        Assert.assertTrue(login.validateInputIsDisplayed(), "fail");
    }

    @Then("^IZ Validate the mail is displayed as span$")
    public void validateTheMailIsDisplayedAsSpan() {
        Assert.assertTrue(login.validateSpanIsDisplayed());

    }

    /*
        Segunda parte
     */

    @Then("^IZ Validate the span icon is displayed in email field$")
    public void validateTheSpanIconIsDisplayed() throws InterruptedException {
        Assert.assertTrue(login.validateSpanIconIsDisplayed());
    }

    @When("^IZ click Can't log in link in Login page")
    public void clickCanTLogInLinkInLoginPage() {
        login.clickCantLogIn();
    }

    @Then("^IZ Verify that the title of the Can't log in page is \"([^\"]*)\"$")
    public void verifyThatTheTitleOfTheCanTLogInPageIs(String textCantLogInExpected) throws Throwable {
        String textActual = login.getTittleCantLogIn();
        Assert.assertEquals(textActual, textCantLogInExpected);
    }

    @When("^IZ click on Log in with Google button$")
    public void clickOnLogInWithGoogleButton() {
        login.clickLogInWithGoogleBtn();
    }


    @When("^IZ set my credential email on login google page$")
    public void setMyCredentialEmailOnLoginGooglePage() {
        loginGoogleForm.setEmailGoogleCredential();
    }


    @When("^IZ set my credentials incorrect password on 'Login' page$")
    public void setMyCredentialsIncorrectPasswordOnLoginPage() {
        login.setIncorrectPasswordCredential();
    }

    @Then("^IZ verify that the error message that is displayed is \"([^\"]*)\"$")
    public void verifyThatTheErrorMessageThatIsDisplayedIs(String textExpected) throws Throwable {
        String textActual = login.getMsgPassError();
        Assert.assertEquals(textActual, textExpected);
    }


    @When("^IZ click on the 'Siguiente' button after set email on login google page$")
    public void clickOnTheSiguienteButtonAfterSetEmailOnLoginGooglePage() {
        loginGoogleForm.clickSiguienteEmailBtn();
    }

    @When("^IZ set my credential password on login google page$")
    public void setMyCredentialPasswordOnLoginGooglePage() {
        loginGoogleForm.setPassGoogleCredential();
    }

    @When("^IZ click on the 'Siguiente' button after set password on login google page$")
    public void clickOnTheSiguienteButtonAfterSetPasswordOnLoginGooglePage() {
        loginGoogleForm.clickSiguientePassBtn();
    }

    @Then("^IZ verify that you can logout$")
    public void verifyThatYouCanLogout() {
        loginMyAccountDialog.logoutBtn();
    }
}
