package ru.training.at.hw6.actions;

import com.epam.jdi.light.elements.composite.Form;
import io.qameta.allure.Step;
import org.testng.Assert;
import ru.training.at.hw6.entities.User;

import java.util.ArrayList;
import java.util.List;

import static ru.training.at.hw6.pages.JdiMetalsAndColorsPage.results;
import static ru.training.at.hw6.pages.JdiSite.*;


@SuppressWarnings("ALL")
public class ActionsAndAllureReport {

    @Step
    public static void openHomePage() {
        jdiHomePage.open();
    }

    @Step
    public static void login(User roman) {
        userIcon.click();
        loginForm.submit(roman, "enter");
//        userIcon.click();
//        loginForm.login(roman);
    }

    @Step
    public static void selectHeaderItem(String itemName) {
        headerMenu.select(itemName);
    }

    @Step
    public static void fillForm(Form form, Object data) {
        form.submit(data);
    }

    @Step
    public static void verifyResults(List<String> expectedList) {
        List<String> actResults = new ArrayList<>();
        for (org.openqa.selenium.WebElement result : results) {
            actResults.add(result.getText());
        }
        Assert.assertEquals(actResults, expectedList);
    }

    @Step
    public static void logout() {
        if (!logout.isDisplayed()) {
            userIcon.click();
        }
        logout.click();
    }




}
