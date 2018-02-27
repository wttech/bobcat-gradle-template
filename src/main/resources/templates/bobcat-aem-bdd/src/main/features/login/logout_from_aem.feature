Feature: Logout
  In order to prevent other people from using my account
  As a logged-in user
  I want to log out

Scenario: Logout from the AEM
  Given I am logged in
  And I have opened projects page
  When I press logout button
  Then I am not logged in
