@addingUser
Feature: Adding a new user
  Scenario: Adding user as a librarian
    Given I am  logged in and on the homePage
    When  I click Users module
    And I click +Add User button
    When I enter "<fullName>", "<password>","<emailAddress>" and "<FullAddress>"
    And I click save changes
    Then I should see new users  in the first row of the web table



   # Examples:
    #  | email              | password|fullName          |  address            |
     # |Mari34@gmail.com    | Mari    | Mari             |Therry ct. Baltimore |

