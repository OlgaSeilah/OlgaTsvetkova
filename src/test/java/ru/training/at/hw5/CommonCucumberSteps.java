package ru.training.at.hw5;

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

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.apache.tika.mime.MediaType.text;


public class CommonCucumberSteps  {

    WebDriver driver = TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER);


    @Given("I open JDI GitHub site")
    public void openHomePage() {
        new HomePage(driver).openSite();
    }

    @And("I login with login {string} and password {string}")
    public void loginInSite(String login, String password) {
        new HomePage(driver).performLogin(login, password);
    }

    @And("I logged in as user {string}")
    public void assertUserName(String username) {
        Assert.assertEquals(new HomePage(driver).getLoggedUserName(),
                username);
    }

    @And("I click on Service button in Header")
    public void clickOnServiceButtonInHeader() {
        new DiffElementsPage(driver).openHeaderMenuService();
    }

    @And("I open {string} page")
    public void openDifferentElementsPage(String pointName) {
        new DiffElementsPage(driver).openPointInMenuService(pointName);
    }

    @When("I select checkbox {string}")
    public void chooseChk(String chekboxName) {
        new DiffElementsPage(driver).chooseChk(chekboxName);
    }

    @When("I select radiobutton {string}")
    public void chooseRb(String rbName) {
        new DiffElementsPage(driver).chooseRadiobutton(rbName);
    }

    @When("I select color {string} from dropdown {string}")
    public void chooseColorInDropdown(String colorName) {
        new DiffElementsPage(driver).chooseColorInDropdown(colorName);
    }

    @Then("There are new line in log field with text {string}")
    public void checkTextInLogAfterClickingOnItem(String expectedText) {
        Assert.assertEquals(new DiffElementsPage(driver).getCuttedTextFromLog(),
                expectedText);
    }

    @Then("{string} page should be opened")
    public void assertionPageTitle(String expectedTitle) {
        Assert.assertEquals(new HomePage(driver).getPageTitle(),
                expectedTitle);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void verifyNumberOfDropDownsOnUserTablePage(int expected) {
        Assert.assertEquals(new UserTablePage(driver)
                        .getNumberTypesDropdowns().size(), expected);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void verifyNumberOfUsernamesOnUserTablePage(int expected) {
        Assert.assertEquals(new UserTablePage(driver)
                        .getUserNames().size(), expected);
    }

    @Then("{int} Description texts under"
            + " images should be displayed on Users Table on User Table Page")
    public void verifyNumberOfDescriptionsOnUserTablePage(int expected) {
        Assert.assertEquals(new UserTablePage(driver)
                        .getImageDescriptionText().size(), expected);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void verifyNumberOfCheckboxesOnUserTablePage(int expected) {
        Assert.assertEquals(new UserTablePage(driver)
                        .getUserCheckboxes().size(), expected);
    }

    UserTablePage userTablePage = new UserTablePage(driver);
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
            Assert.assertEquals(new UserTablePage(driver)
                    .getTextItemsInDropdownRoman().get(i), list.get(i));
        }
    }

    @When("I select 'vip' checkbox for Sergey Ivan")
    public void selectVipCheckboxOnSergeyIvan() {
        userTablePage.getUserCheckboxes().get(1).click();
    }








    }











