Feature: Login

#Terminado
  Scenario: Log in with correct data
    Given 'Jira' main page is loaded
    And click on the 'Login' button on the main page
    When set my credentials mail on 'Login' page
    And click 'Continue' button in 'Login' page
    And set my credentials password on 'Login' page
    And click 'Log in' button in 'Login' page
    Then verify that you have logged in with the user "Ivan Zapata"
    And verify that you have logged in with the mail "ivazato@gmail.com"

#Terminado
  Scenario: Validate that input field is displayed
    Given 'Jira' main page is loaded
    And click on the 'Login' button on the main page
    When set my credentials mail on 'Login' page
    Then Validate the field is displayed

#  Terminado
  Scenario: Edit the email field
    Given 'Jira' main page is loaded
    And click on the 'Login' button on the main page
    When set my credentials mail on 'Login' page
    And click 'Continue' button in 'Login' page
    Then Validate the mail is displayed as spam


#  Terminado
#  Enlazar al formulario de registro si email no esta registrado
  Scenario: Redirect to registration form if email is not registered
    Given 'Jira' main page is loaded
    And click on the 'Login' button on the main page
    When set mail: dsds@xyz.com
    And click 'Continue' button in 'Login' page
    Then Verify that the name of the page should be "Sign up for your account"


