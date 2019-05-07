Feature: Login

  #2. Terminado
  Scenario: IZ Validate that input field is displayed
    Given IZ 'Jira' main page is loaded
    And IZ click on the 'Login' button on the main page
    When IZ set my credentials mail on 'Login' page
    Then IZ Validate the field is displayed

  #3. Terminado
  Scenario: IZ Validate that email field is displayed as span after to click on continue button
    Given IZ 'Jira' main page is loaded
    And IZ click on the 'Login' button on the main page
    When IZ set my credentials mail on 'Login' page
    And IZ click 'Continue' button in 'Login' page
    Then IZ Validate the mail is displayed as span


  #4. Terminado
  Scenario: IZ Redirect to registration form if email is not registered
    Given IZ 'Jira' main page is loaded
    And IZ click on the 'Login' button on the main page
    When IZ set mail: dsds@xyz.com
    And IZ click 'Continue' button in 'Login' page
    Then IZ Verify that the name of the page should be "Sign up for your account"


#SEGUNDA PARTE


  #5. Terminado
  Scenario: IZ Validate warning icon is displayed with empty mail
    Given IZ 'Jira' main page is loaded
    When IZ click on the 'Login' button on the main page
    And IZ click 'Continue' button in 'Login' page
    Then IZ Validate the span icon is displayed in email field


  #6. Terminado
  Scenario: IZ validate that the link 'Can not log in?' address password recovery form
    Given IZ 'Jira' main page is loaded
    When IZ click on the 'Login' button on the main page
    And IZ click Can't log in link in Login page
    Then IZ Verify that the title of the Can't log in page is "Can't log in?"


  #7. Terminado
  Scenario: Log in with google account
    Given IZ 'Jira' main page is loaded
    When IZ click on the 'Login' button on the main page
    And IZ click on Log in with Google button
    And IZ set my credential email on login google page
    And IZ click on the 'Siguiente' button after set email on login google page
    And IZ set my credential password on login google page
    And IZ click on the 'Siguiente' button after set password on login google page
    Then IZ verify that you have logged in with the user "prueba jira"
    And IZ verify that you have logged in with the mail "pruebajira111@gmail.com"
    And IZ verify that you can logout

  #8. Terminado
  Scenario: IZ validate that it shows an error message when an incorrect password is set
    Given IZ 'Jira' main page is loaded
    And IZ click on the 'Login' button on the main page
    When IZ set my credentials mail on 'Login' page
    And IZ click 'Continue' button in 'Login' page
    And IZ set my credentials incorrect password on 'Login' page
    And IZ click 'Log in' button in 'Login' page
    Then IZ verify that the error message that is displayed is "Incorrect email address and / or password."


  #9. Terminado
  Scenario: IZ Validate the email field is visible after on click edit icon
    Given IZ 'Jira' main page is loaded
    And IZ click on the 'Login' button on the main page
    When IZ set my credentials mail on 'Login' page
    And IZ click 'Continue' button in 'Login' page
    Then IZ Validate the mail is displayed as span
    When IZ click on the icon edit button of the email field
    Then IZ Validate the field is displayed


    #1. Terminado
  # 1.Iniciar sesión con datos correctos
  Scenario: IZ Log in with correct data
    Given IZ 'Jira' main page is loaded
    And IZ click on the 'Login' button on the main page
    When IZ set my credentials mail on 'Login' page
    And IZ click 'Continue' button in 'Login' page
    And IZ set my credentials password on 'Login' page
    And IZ click 'Log in' button in 'Login' page
    Then IZ verify that you have logged in with the user "Ivan Zapata"
    And IZ verify that you have logged in with the mail "ivazato@gmail.com"
