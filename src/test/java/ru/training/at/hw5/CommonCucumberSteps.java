package ru.training.at.hw5;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.pages.BasePage;
import ru.training.at.hw5.pages.HomePage;
import ru.training.at.hw5.utils.WebdriverManager;

import java.util.List;
import java.util.Properties;
import org.picocontainer.annotations.Inject;


public class CommonCucumberSteps extends ParentPageForCucumberSteps {

    BasePage basePage = new BasePage(driver);
    HomePage homePage = new HomePage(driver);

    @Given("Open site jdi")
    public void openHomePage() {
//        homePage.openSite();
        WebdriverManager.driver.navigate().to(basePage.getUrlFromProps());
    }

    @And("User is logged in with login {string} and password {string}")
    public void loginInSite(String login, String password) {
        homePage.performLogin(login, password);
    }

    //TODO give the name of page in String
    @And("Open Different Elements Page")
    public void openDifferentElementsPage() {
        homePage.openHeaderMenuService();
        homePage.openPointInMenuService("Different Elements Page");
    }



}
