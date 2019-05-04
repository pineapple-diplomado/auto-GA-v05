Feature: Login

  #1. Terminado
  # 1.Iniciar sesión con datos correctos
  Scenario: Log in with correct data
    Given 'Jira' main page is loaded
    And click on the 'Login' button on the main page
    When set my credentials mail on 'Login' page
    And click 'Continue' button in 'Login' page
    And set my credentials password on 'Login' page
    And click 'Log in' button in 'Login' page
    Then verify that you have logged in with the user "Ivan Zapata"
    And verify that you have logged in with the mail "ivazato@gmail.com"


  #2. Terminado
  Scenario: Validate that input field is displayed
    Given 'Jira' main page is loaded
    And click on the 'Login' button on the main page
    When set my credentials mail on 'Login' page
    Then Validate the field is displayed

  #3. Terminado
  Scenario: Validate that email field is displayed as span after to click on continue button
    Given 'Jira' main page is loaded
    And click on the 'Login' button on the main page
    When set my credentials mail on 'Login' page
    And click 'Continue' button in 'Login' page
    Then Validate the mail is displayed as span


  #4. Terminado
  Scenario: Redirect to registration form if email is not registered
    Given 'Jira' main page is loaded
    And click on the 'Login' button on the main page
    When set mail: dsds@xyz.com
    And click 'Continue' button in 'Login' page
    Then Verify that the name of the page should be "Sign up for your account"


#SEGUNDA PARTE


  #5. Terminado
  Scenario: Validate warning icon is displayed with empty mail
    Given 'Jira' main page is loaded
    When click on the 'Login' button on the main page
    And click 'Continue' button in 'Login' page
    Then Validate the span icon is displayed in email field


  #6. Terminado
  Scenario: validate that the link 'Can not log in?' address password recovery form
    Given 'Jira' main page is loaded
    When click on the 'Login' button on the main page
    And click Can't log in link in Login page
    Then Verify that the title of the Can't log in page is "Can't log in?"


  #7. Terminado
  Scenario: Log in with google account
    Given 'Jira' main page is loaded
    When click on the 'Login' button on the main page
    And click on Log in with Google button
    And set my credential email on login google page
    And click on the 'Siguiente' button after set email on login google page
    And set my credential password on login google page
    And click on the 'Siguiente' button after set password on login google page
    Then verify that you have logged in with the user "prueba jira"
    And verify that you have logged in with the mail "pruebajira111@gmail.com"

  #8. Terminado
  Scenario: validate that it shows an error message when an incorrect password is set
    Given 'Jira' main page is loaded
    And click on the 'Login' button on the main page
    When set my credentials mail on 'Login' page
    And click 'Continue' button in 'Login' page
    And set my credentials incorrect password on 'Login' page
    And click 'Log in' button in 'Login' page
    Then verify that the error message that is displayed is "Incorrect email address and / or password."


  #9. Terminado
  Scenario: Validate the email field is visible after on click edit icon
    Given 'Jira' main page is loaded
    And click on the 'Login' button on the main page
    When set my credentials mail on 'Login' page
    And click 'Continue' button in 'Login' page
    Then Validate the mail is displayed as span
    When click on the icon edit button of the email field
    Then Validate the field is displayed