package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;
    Properties properties = null;
//    String homePageTitle = UsedInTestTerms.homePageTitle;
//    String loggedUser = UsedInTestTerms.loggedUserName;
    String expectedUserName = TestDataForAssertions.expectedUserName;

    protected String login;
    protected String password;


    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            driver = WebdriverManager.setUpDriver();
        }
        properties = DataProperties.getTestDataProps();
        login = properties.getProperty("login");
        password = properties.getProperty("password");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
