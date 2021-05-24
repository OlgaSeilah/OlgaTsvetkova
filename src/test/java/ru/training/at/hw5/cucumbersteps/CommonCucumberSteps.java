package ru.training.at.hw5.cucumbersteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.DiffElementsPage;
import ru.training.at.hw5.pages.HomePage;
import ru.training.at.hw5.pages.UserTablePage;

import java.util.List;
import java.util.Map;


public class CommonCucumberSteps  {

    WebDriver driver = TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER);
    HomePage homePage = new HomePage(driver);
    DiffElementsPage diffElementsPage = new DiffElementsPage(driver);
    UserTablePage userTablePage = new UserTablePage(driver);


    @Given("I open JDI GitHub site")
    public void openHomePage() {
        homePage.openSite();
    }

    @And("I login with login {string} and password {string}")
    public void loginInSite(String login, String password) {
        homePage.performLogin(login, password);
    }

    @And("I logged in as user {string}")
    public void assertUserName(String username) {
        Assert.assertEquals(homePage.getLoggedUserName(),
                username);
    }

    @And("I click on Service button in Header")
    public void clickOnServiceButtonInHeader() {
        diffElementsPage.openHeaderMenuService();
    }

    @And("I open {string} page")
    public void openDifferentElementsPage(String pointName) {
        diffElementsPage.openPointInMenuService(pointName);
    }

    @When("I select checkbox {string}")
    public void chooseChk(String chekboxName) {
        diffElementsPage.chooseChk(chekboxName);
    }

    @When("I select radiobutton {string}")
    public void chooseRb(String rbName) {
        diffElementsPage.chooseRadiobutton(rbName);
    }

    @When("I select color {string} from dropdown {string}")
    public void chooseColorInDropdown(String colorName, String dropdownName) {
        diffElementsPage.chooseColorInDropdown(colorName);
    }

    @Then("There are new line in log field with text {string} after current time")
    public void checkTextInLogAfterClickingOnItem(String expectedText) {
        Assert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                expectedText);
    }

    @Then("{string} page should be opened")
    public void assertionPageTitle(String expectedTitle) {
        Assert.assertEquals(homePage.getPageTitle(),
                expectedTitle);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void verifyNumberOfDropDownsOnUserTablePage(int expected) {
        Assert.assertEquals(userTablePage
                        .getNumberTypesDropdowns().size(), expected);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void verifyNumberOfUsernamesOnUserTablePage(int expected) {
        Assert.assertEquals(userTablePage
                        .getUserNames().size(), expected);
    }

    @Then("{int} Description texts under"
            + " images should be displayed on Users Table on User Table Page")
    public void verifyNumberOfDescriptionsOnUserTablePage(int expected) {
        Assert.assertEquals(userTablePage
                        .getImageDescriptionText().size(), expected);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void verifyNumberOfCheckboxesOnUserTablePage(int expected) {
        Assert.assertEquals(userTablePage
                        .getUserCheckboxes().size(), expected);
    }

    @And("User table should contain following values")
    public void assertUserTableValues(DataTable dataTable) {

        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < table.size(); i++) {
            Assert.assertEquals(userTablePage.getNumbersText(i), table.get(i).get("number"));
            Assert.assertEquals(userTablePage.getNamesText(i), table.get(i).get("name"));
            Assert.assertEquals(userTablePage
                    .getImageDescriptionText(i), table.get(i).get("description"));
        }
    }

    @And("droplist should contain values in column Type for user Roman")
    public void assertDroplistRomanValues(List<String> list) {
        userTablePage.clickOnDropdownRomanToOpen();

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(userTablePage
                    .getTextItemsInDropdownRoman().get(i), list.get(i));
        }
    }

    @When("I select 'vip' checkbox for Sergey Ivan")
    public void selectVipCheckboxOnSergeyIvan() {
        userTablePage.getUserCheckboxes().get(1).click();
    }


}











