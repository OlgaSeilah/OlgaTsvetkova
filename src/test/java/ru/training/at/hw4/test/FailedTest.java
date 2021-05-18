package ru.training.at.hw4.test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.steps.JdiPageSteps;


@Feature("Failed test")
@Story("Failed test")
public class FailedTest extends BaseTest {

    SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        softAssert = new SoftAssert();
    }

    @Test(description = "test of the 1st page")
    public void ex1_failed() {
        JdiPageSteps jdiPageStepsSteps = new JdiPageSteps(driver,  properties,
                expectedTextFromLinksInHeader,
                expectedTextFromLeftMenuItems,
                login, password);

        jdiPageStepsSteps.openHomePage();
        jdiPageStepsSteps.loginInSite();
        jdiPageStepsSteps.assertUserNameIncorrect();
        jdiPageStepsSteps.assertPageTitle();
        jdiPageStepsSteps.assertHeaderLinksNames();
        jdiPageStepsSteps.assertBenefitPics();
        jdiPageStepsSteps.assertTextsunderBenefitPics();
        jdiPageStepsSteps.assertIframeIsDisplayed();
        jdiPageStepsSteps.assertFrameButtonExists();
        jdiPageStepsSteps.assertLeftMenuItemsTxts();
    }


}
