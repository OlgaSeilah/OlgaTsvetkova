package ru.training.at.hw3.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.training.at.hw3.utils.DataProperties;
import ru.training.at.hw3.utils.TestDataForAssertions;
import ru.training.at.hw3.utils.WebdriverManager;
import ru.training.at.hw3.pages.DiffElementsPage;
import ru.training.at.hw3.pages.HomePage;

import java.util.List;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;
    DiffElementsPage diffElementsPage;
    Properties properties = null;

    String expectedUserName = TestDataForAssertions.EXPECTED_USER_NAME;
    List<String> expectedTextFromLinksInHeader =
            TestDataForAssertions.expectedTextFromLinksInHeader;
    List<String> expectedTextFromLeftMenuItems =
            TestDataForAssertions.EXPECTED_TEXT_FROM_LEFT_MENU_ITEMS;

    String expected1Txt = TestDataForAssertions.EXPECTED_1_TXT;
    String expected2Txt = TestDataForAssertions.EXPECTED_2_TXT;
    String expected3Txt = TestDataForAssertions.EXPECTED_3_TXT;
    String expected4Txt = TestDataForAssertions.expected4Txt;

    protected String login;
    protected String password;


    @BeforeMethod
    public void setUp() {
        driver = WebdriverManager.setUpDriver();
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
