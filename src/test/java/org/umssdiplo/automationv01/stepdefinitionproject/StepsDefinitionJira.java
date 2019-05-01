package org.umssdiplo.automationv01.stepdefinitionproject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.umssdiplo.automationv01.core.managepage.Login.Login;
import org.umssdiplo.automationv01.core.managepage.Pages.MyAccountDialog;
import org.umssdiplo.automationv01.core.managepage.Pages.RegisterForm;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StepsDefinitionJira {
    private Login login;

    private MyAccountDialog myAccountDialog = new MyAccountDialog();

    private RegisterForm registerForm = new RegisterForm();

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

    @And("^click on the icon edit button of the email field$")
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

    @Then("^Validate the mail is displayed as spam$")
    public void validateTheMailIsDisplayedAsSpam() {
        Assert.assertTrue(login.validateSpamIsDisplayed());

    }
}
