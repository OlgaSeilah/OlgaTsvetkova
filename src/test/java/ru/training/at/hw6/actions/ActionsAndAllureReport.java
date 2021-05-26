package ru.training.at.hw6.actions;

import io.qameta.allure.Step;
import org.testng.Assert;
import ru.training.at.hw6.entities.MetalsAndColors;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.forms.MetalsAndColorsForm;

import java.util.ArrayList;
import java.util.List;

import static ru.training.at.hw6.pages.JDIMetalsAndColorsPage.results;
import static ru.training.at.hw6.pages.JdiSite.*;


//@SuppressWarnings("ALL")
public class ActionsAndAllureReport {

//    @Step
    public static void openHomePage() {
        jdiHomePage.open();
    }

    @Step
    public static void login(User user) {
        userIcon.click();
        loginForm.submit(user, "enter");
    }


    public static void selectHeaderItem(String itemName) {
        headerMenu.select(itemName);
    }


    public static void fillForm(MetalsAndColorsForm form, Object data) {
        form.submit((MetalsAndColors) data);
    }


    public static void verifyResults(List<String> expectedList) {
        List<String> actResults = new ArrayList<>();
        for (org.openqa.selenium.WebElement result : results) {
            actResults.add(result.getText());
        }
        Assert.assertEquals(actResults, expectedList);
    }

    @Step
    public static void logout() {
        if(!logout.isDisplayed()) {
            userIcon.click();
        }
        logout.click();
    }




}
