package ru.training.at.hw4.test;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.pages.DiffElementsPage;
import ru.training.at.hw4.pages.HomePage;
import ru.training.at.hw4.steps.JdiPageTest;

import java.util.List;

import static ru.training.at.hw4.pages.DiffElementsPage.ChooseCheckbox.Water;
import static ru.training.at.hw4.pages.DiffElementsPage.ChooseCheckbox.Wind;
import static ru.training.at.hw4.pages.DiffElementsPage.ChooseColor.Yellow;
import static ru.training.at.hw4.pages.DiffElementsPage.ChooseRb.Selen;

@Feature("Feature Exercise 1 - point 5")
@Story("Story Exercise 1 - point 5")
public class AllureTest extends BaseTest {

    SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        softAssert = new SoftAssert();
    }

    @Test
    public void ex1() {
        JdiPageTest jdiPageTestSteps = new JdiPageTest(driver);

        jdiPageTestSteps.openHomePage();
        jdiPageTestSteps.loginInSite();
        jdiPageTestSteps.assertUserName();
        jdiPageTestSteps.assertPageTitle();
        jdiPageTestSteps.assertHeaderLinksNames();
        jdiPageTestSteps.assertBenefitPics();
        jdiPageTestSteps.assertTextsunderBenefitPics();
        jdiPageTestSteps.assertIframeIsDisplayed();
        jdiPageTestSteps.assertFrameButtonExists();
        jdiPageTestSteps.assertLeftMenuItemsTxts();
    }



}
