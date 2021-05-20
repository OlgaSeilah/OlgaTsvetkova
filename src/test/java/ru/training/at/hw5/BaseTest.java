package ru.training.at.hw5;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.training.at.hw4.utils.DataProperties;
import ru.training.at.hw4.utils.WebdriverManager;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class BaseTest {
    public WebDriver getDriver() {
        return driver;
    }

    WebDriver driver;
    Properties properties = null;

    protected String login;
    protected String password;

    protected List<String> expectedTextFromLinksInHeader;
    protected List<String> expectedTextFromLeftMenuItems;


    @BeforeMethod
    public void setUp() {
        driver = WebdriverManager.setUpDriver();
        properties = DataProperties.getTestDataProps();
        login = properties.getProperty("login");
        password = properties.getProperty("password");
        expectedTextFromLinksInHeader =
                Arrays.asList(properties.getProperty(
                        "expectedTextFromLinksInHeader").split(", "));
        expectedTextFromLeftMenuItems =
                Arrays.asList(properties.getProperty(
                        "EXPECTED_TEXT_FROM_LEFT_MENU_ITEMS").split(", "));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
