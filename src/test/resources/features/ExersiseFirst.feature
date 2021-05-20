Feature: Cheking different elements page (1st Ex)

  Scenario: Login and go to the Different Elements Page
    Given Open site jdi
    And User is logged in with login "Roman" and password "Jdi1234"
    And Open Different Elements Page
#    And Different Elements Page is opened

#  Scenario: Check the elements on the page
    When Check checkbox "Water" in checkbox line
    Then There are new line in log field with text '"Water:" condition changed to true' after current time
    When Check checkbox "Wind" in checkbox line
    Then There are new line in log field with text '"Wind:" condition changed to true' after current time
    When Check radiobutton "Selen" in radiobuttons line
    Then There are new line in log field with text '"Wind:" condition changed to true' after current time
    When Choose color "Yellow" in color dropdown
    Then There are new line in log field with text '"Wind:" condition changed to true' after current time
