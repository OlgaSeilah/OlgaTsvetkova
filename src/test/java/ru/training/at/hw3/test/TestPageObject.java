package ru.training.at.hw3.test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pages.DiffElementsPage;
import ru.training.at.hw3.pages.HomePage;

import java.util.List;

import static ru.training.at.hw3.utils.TestDataForAssertions.*;

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
        softAssert.assertEquals(homePage.getPageTitle(), EXPECTED_PAGE_TITLE);

        homePage.performLogin(login, password);
        softAssert.assertEquals(homePage.getLoggedUserName(), expectedUserName);

        List<String> collectionOfLinksInHeader = homePage.getCollectionOfLinksTextsInHeader();
        softAssert.assertEquals(collectionOfLinksInHeader, expectedTextFromLinksInHeader);

        List<WebElement> benefitIcons = homePage.getBenefitIcons();
        for (WebElement pic : benefitIcons) {
            softAssert.assertTrue(pic.isDisplayed());
        }

        List<String> benefitTxts = homePage.getBenefitTxts();
        softAssert.assertEquals(benefitTxts.get(0), expected1Txt);
        softAssert.assertEquals(benefitTxts.get(1), expected2Txt);
        softAssert.assertEquals(benefitTxts.get(2), expected3Txt);
        softAssert.assertEquals(benefitTxts.get(3), expected4Txt);

        softAssert.assertTrue(homePage.getIframe().isDisplayed());

        homePage.switchToFrame();
        softAssert.assertTrue(homePage.isFrameButtonExists());
        homePage.switchBackToParentPage();

        softAssert.assertEquals(homePage.getLeftMenuItemsTxts(), expectedTextFromLeftMenuItems);
    }

    @Test
    public void ex2() {
        homePage = new HomePage(driver);
        diffElementsPage = new DiffElementsPage(driver);

        homePage.openSite();
        softAssert.assertEquals(homePage.getPageTitle(), EXPECTED_PAGE_TITLE);

        homePage.performLogin(login, password);
        softAssert.assertEquals(homePage.getLoggedUserName(), expectedUserName);

        homePage.openHeaderMenuService();
        homePage.openPointInMenuService("Different Elements Page");

        diffElementsPage.chooseCheckbox("Water");
        softAssert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                EXPECTED_ROW_IN_LOG_WATER);

        diffElementsPage.chooseCheckbox("Wind");
        softAssert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                EXPECTED_ROW_IN_LOG_WIND);

        diffElementsPage.chooseRadiobutton("Selen");
        softAssert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                EXPECTED_ROW_IN_LOG_SELEN);

        diffElementsPage.chooseColorInDropdown("Yellow");
        softAssert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                EXPECTED_ROW_IN_LOG_YELLOW);


    }

}
