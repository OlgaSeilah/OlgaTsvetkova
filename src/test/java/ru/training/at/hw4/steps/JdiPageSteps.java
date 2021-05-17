package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.pages.DiffElementsPage;
import ru.training.at.hw4.pages.HomePage;

import java.util.List;
import java.util.Properties;

import static ru.training.at.hw4.pages.DiffElementsPage.ChooseCheckbox.Water;
import static ru.training.at.hw4.pages.DiffElementsPage.ChooseCheckbox.Wind;
import static ru.training.at.hw4.pages.DiffElementsPage.ChooseColor.Yellow;
import static ru.training.at.hw4.pages.DiffElementsPage.ChooseRb.Selen;

public class JdiPageSteps {

    HomePage homePage;
    DiffElementsPage diffElementsPage;
    Properties properties;

    protected String login;
    protected String password;

    protected List<String> expectedTextFromLinksInHeader;
    protected List<String> expectedTextFromLeftMenuItems;


    public JdiPageSteps(WebDriver driver, Properties properties,
                        List<String> expectedTextFromLinksInHeader,
                        List<String> expectedTextFromLeftMenuItems,
                        String login, String password ) {
        homePage = new HomePage(driver);
        diffElementsPage = new DiffElementsPage(driver);
        this.login = login;
        this.properties = properties;
        this.password = password;
        this.expectedTextFromLeftMenuItems = expectedTextFromLeftMenuItems;
        this.expectedTextFromLinksInHeader = expectedTextFromLinksInHeader;

    }

    @Step("Open jdi home page on link")
    public void openHomePage() {
        homePage.openSite();
    }

    @Step("Log in")
    public void loginInSite() {
        homePage.performLogin(login, password);
    }

    @Step("Assert if user has current username")
    public void assertUserName() {
        Assert.assertEquals(homePage.getLoggedUserName(),
                properties.getProperty("EXPECTED_USER_NAME"));
    }

    @Step("Assert if page has current title")
    public void assertPageTitle() {
        Assert.assertEquals(homePage.getPageTitle(),
                properties.getProperty("EXPECTED_PAGE_TITLE"));
    }

    @Step("Assert if page has correct header links names")
    public void assertHeaderLinksNames() {
        List<String> collectionOfLinksInHeader = homePage.getCollectionOfLinksTextsInHeader();
        Assert.assertEquals(collectionOfLinksInHeader, expectedTextFromLinksInHeader);
    }

    @Step("Assert if page has 4 benefit pictures")
    public void assertBenefitPics() {
        List<WebElement> benefitIcons = homePage.getBenefitIcons();
        for (WebElement pic : benefitIcons) {
            Assert.assertTrue(pic.isDisplayed());
        }
    }

    @Step("Assert if it's current text blocs under pics")
    public void assertTextsunderBenefitPics() {
        List<String> benefitTxts = homePage.getBenefitTxts();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(benefitTxts.get(0), properties.getProperty("EXPECTED_1_TXT"));
        softAssert.assertEquals(benefitTxts.get(1), properties.getProperty("EXPECTED_2_TXT"));
        softAssert.assertEquals(benefitTxts.get(2), properties.getProperty("EXPECTED_3_TXT"));
        softAssert.assertEquals(benefitTxts.get(3), properties.getProperty("EXPECTED_4_TXT"));
    }

    @Step("iFrame is displayed")
    public void assertIframeIsDisplayed() {
        Assert.assertTrue(homePage.getIframe().isDisplayed());
    }

    @Step("Button in frame exists")
    public void assertFrameButtonExists() {
        homePage.switchToFrame();
        Assert.assertTrue(homePage.isFrameButtonExists());
        homePage.switchBackToParentPage();
    }

    @Step("Left menu has right points")
    public void assertLeftMenuItemsTxts() {
        Assert.assertEquals(homePage.getLeftMenuItemsTxts(),
                expectedTextFromLeftMenuItems);
    }

    @Step("Open Different Elements Page")
    public void openDifferentElementsPage() {
        homePage.openHeaderMenuService();
        homePage.openPointInMenuService("Different Elements Page");
    }

    @Step("Check text in log after clicking on Water checkbox")
    public void checkTextInLogAfterClickingOnWaterChckbx() {
        diffElementsPage.chooseChk(Water);
        Assert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                properties.getProperty("EXPECTED_ROW_IN_LOG_WATER"));
    }

    @Step("Check text in log after clicking on Wind checkbox")
    public void checkTextInLogAfterClickingOnWindChckbx() {
        diffElementsPage.chooseChk(Wind);
        Assert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                properties.getProperty("EXPECTED_ROW_IN_LOG_WIND"));
    }

    @Step("Check text in log after clicking on Selen radiobutton")
    public void checkTextInLogAfterClickingOnSelenRb() {
        diffElementsPage.chooseRadiobutton(Selen);
        Assert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                properties.getProperty("EXPECTED_ROW_IN_LOG_SELEN"));
    }

    @Step("Check text in log after clicking on Yellow point in dropdown")
    public void checkTextInLogAfterClickingOnYellowPointInDrodown() {
        diffElementsPage.chooseColorInDropdown(Yellow);
        Assert.assertEquals(diffElementsPage.getCuttedTextFromLog(),
                properties.getProperty("EXPECTED_ROW_IN_LOG_YELLOW"));
    }


}
