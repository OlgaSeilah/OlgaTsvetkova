Feature: Exercise 3

  Scenario: User Table Page elements test
    Given I open JDI GitHub site
    And I login with login "Roman" and password "Jdi1234"
    And I logged in as user "ROMAN IOVLEV"
    And I click on Service button in Header
    And I open "User Table" page
    When I select 'vip' checkbox for Sergey Ivan
    Then There are new line in log field with text "Vip: condition changed to true" after current time