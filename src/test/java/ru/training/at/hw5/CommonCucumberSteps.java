package ru.training.at.hw5;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.pages.BasePage;
import ru.training.at.hw5.pages.HomePage;
import ru.training.at.hw5.utils.WebdriverManager;

import java.util.List;
import java.util.Properties;
import org.picocontainer.annotations.Inject;


public class CommonCucumberSteps  {

    WebDriver driver = TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER);


    @Given("Open site jdi")
    public void openHomePage() {
//        homePage.openSite();
//        WebdriverManager.driver.navigate().to(basePage.getUrlFromProps());

        new HomePage(driver).openSite();
    }

    @And("User is logged in with login {string} and password {string}")
    public void loginInSite(String login, String password) {
        new HomePage(driver).performLogin(login, password);
    }
//
//    //TODO give the name of page in String
//    @And("Open Different Elements Page")
//    public void openDifferentElementsPage() {
//        homePage.openHeaderMenuService();
//        homePage.openPointInMenuService("Different Elements Page");
//    }
//


}
