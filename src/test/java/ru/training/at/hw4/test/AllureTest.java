package ru.training.at.hw4.test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.steps.JdiPageSteps;


@Feature("Feature Exercise 1 - point 5")
@Story("Story Exercise 1 - point 5")
public class AllureTest extends BaseTest {

    SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        softAssert = new SoftAssert();
    }

    @Test(description = "test of the 1st page")
    public void ex1() {
        JdiPageSteps jdiPageStepsSteps = new JdiPageSteps(driver,  properties,
                expectedTextFromLinksInHeader,
                expectedTextFromLeftMenuItems,
                login, password);

        jdiPageStepsSteps.openHomePage();
        jdiPageStepsSteps.loginInSite();
        jdiPageStepsSteps.assertUserName();
        jdiPageStepsSteps.assertPageTitle();
        jdiPageStepsSteps.assertHeaderLinksNames();
        jdiPageStepsSteps.assertBenefitPics();
        jdiPageStepsSteps.assertTextsunderBenefitPics();
        jdiPageStepsSteps.assertIframeIsDisplayed();
        jdiPageStepsSteps.assertFrameButtonExists();
        jdiPageStepsSteps.assertLeftMenuItemsTxts();
    }

    @Test(description = "test of the 2nd page")
    public void ex2() {
        JdiPageSteps jdiPageStepsSteps = new JdiPageSteps(driver,  properties,
                expectedTextFromLinksInHeader,
                expectedTextFromLeftMenuItems,
                login, password);

        jdiPageStepsSteps.openHomePage();
        jdiPageStepsSteps.loginInSite();
        jdiPageStepsSteps.assertUserName();
        jdiPageStepsSteps.assertPageTitle();
        jdiPageStepsSteps.openDifferentElementsPage();
        jdiPageStepsSteps.checkTextInLogAfterClickingOnWaterChckbx();
        jdiPageStepsSteps.checkTextInLogAfterClickingOnWindChckbx();
        jdiPageStepsSteps.checkTextInLogAfterClickingOnSelenRb();
        jdiPageStepsSteps.checkTextInLogAfterClickingOnYellowPointInDrodown();
    }



}
