package ru.training.at.hw5;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.BasePage;
import ru.training.at.hw5.pages.DiffElementsPage;
import ru.training.at.hw5.pages.HomePage;
import ru.training.at.hw5.utils.WebdriverManager;

import java.util.List;
import java.util.Properties;
import org.picocontainer.annotations.Inject;


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

    //TODO give the name of page in String
    @And("I click on Service button in Header")
    public void openDifferentElementsPage() {
        new DiffElementsPage(driver).openHeaderMenuService();
    }

    @And("I open {string}")
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





}
