package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw4.pages.DiffElementsPage;
import ru.training.at.hw4.pages.HomePage;

import java.util.List;
import java.util.Properties;

public class JdiPageTest {

    WebDriver driver;
    HomePage homePage;
    DiffElementsPage diffElementsPage;
    Properties properties = null;

    protected String login;
    protected String password;

    protected List<String> expectedTextFromLinksInHeader;
    protected List<String> expectedTextFromLeftMenuItems;


    public JdiPageTest(WebDriver driver) {
        homePage = new HomePage(driver);
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
        Assert.assertEquals(benefitTxts.get(0), properties.getProperty("EXPECTED_1_TXT"));
        Assert.assertEquals(benefitTxts.get(1), properties.getProperty("EXPECTED_2_TXT"));
        Assert.assertEquals(benefitTxts.get(2), properties.getProperty("EXPECTED_3_TXT"));
        Assert.assertEquals(benefitTxts.get(3), properties.getProperty("EXPECTED_4_TXT"));
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


}
