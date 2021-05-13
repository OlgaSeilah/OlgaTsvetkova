package ru.training.at.hw3.test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pages.DiffElementsPage;
import ru.training.at.hw3.pages.HomePage;

import java.util.List;


public class TestPageObject extends BaseTest {

    SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        softAssert = new SoftAssert();
    }

    @Test
    public void ex1() {
        homePage = new HomePage(driver);

        homePage.openSite();
        softAssert.assertEquals(homePage.getPageTitle(), properties.getProperty("EXPECTED_PAGE_TITLE"));

        homePage.performLogin(login, password);
        softAssert.assertEquals(homePage.getLoggedUserName(), properties.getProperty("EXPECTED_USER_NAME"));

        List<String> collectionOfLinksInHeader = homePage.getCollectionOfLinksTextsInHeader();
        softAssert.assertEquals(collectionOfLinksInHeader, expectedTextFromLinksInHeader);

        List<WebElement> benefitIcons = homePage.getBenefitIcons();
        for (WebElement pic : benefitIcons) {
            softAssert.assertTrue(pic.isDisplayed());
        }

        List<String> benefitTxts = homePage.getBenefitTxts();
        softAssert.assertEquals(benefitTxts.get(0), properties.getProperty("EXPECTED_1_TXT"));
        softAssert.assertEquals(benefitTxts.get(1), properties.getProperty("EXPECTED_2_TXT"));
        softAssert.assertEquals(benefitTxts.get(2), properties.getProperty("EXPECTED_3_TXT"));
        softAssert.assertEquals(benefitTxts.get(3), properties.getProperty("EXPECTED_4_TXT"));

        softAssert.assertTrue(homePage.getIframe().isDisplayed());

        homePage.switchToFrame();
        softAssert.assertTrue(homePage.isFrameButtonExists());
        homePage.switchBackToParentPage();

        softAssert.assertEquals(homePage.getLeftMenuItemsTxts(),
                expectedTextFromLeftMenuItems);
    }

    @Test
    public void ex2() {
        homePage = new HomePage(driver);
        diffElementsPage = new DiffElementsPage(driver);

        homePage.openSite();
        softAssert.assertEquals(homePage.getPageTitle(), properties.getProperty("EXPECTED_PAGE_TITLE"));

        homePage.performLogin(login, password);
        softAssert.assertEquals(homePage.getLoggedUserName(), properties.getProperty("EXPECTED_USER_NAME"));

        homePage.openHeaderMenuService();
        homePage.openPointInMenuService("Different Elements Page");

        diffElementsPage.chooseCheckbox("Water");
        softAssert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                properties.getProperty("EXPECTED_ROW_IN_LOG_WATER"));

        diffElementsPage.chooseCheckbox("Wind");
        softAssert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                properties.getProperty("EXPECTED_ROW_IN_LOG_WIND"));

        diffElementsPage.chooseRadiobutton("Selen");
        softAssert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                properties.getProperty("EXPECTED_ROW_IN_LOG_SELEN"));

        diffElementsPage.chooseColorInDropdown("Yellow");
        softAssert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                properties.getProperty("EXPECTED_ROW_IN_LOG_YELLOW"));


    }

}
