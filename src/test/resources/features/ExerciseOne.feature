Feature: Exercise 1

  Scenario: JDI-testing site. Running Exercise 1 steps.
    Given I open JDI GitHub site
    And I login with login "Roman" and password "Jdi1234"
    And I logged in as user "ROMAN IOVLEV"
    And I click on Service button in Header
    And I open "Different Elements Page" page
    When I select checkbox "Water"
    Then There are new line in log field with text "Water: condition changed to true' after current time"
    And I select checkbox "Wind"
    Then There are new line in log field with text "Wind: condition changed to true' after current time"
    And  I select radiobutton "Selen"
    Then There are new line in log field with text "Selen: condition changed to true' after current time"
    And  I select color "Yellow" from dropdown "Colors"
    Then There are new line in log field with text "Yellow: condition changed to true' after current time"


