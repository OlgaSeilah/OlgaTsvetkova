package ru.training.at.hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Homework2 extends BaseClass {

    SoftAssert softAssert;


    @BeforeMethod
    public void createSoftAssert() {
        softAssert = new SoftAssert();
    }

    @Test
    public void testEx1() {
        //Open test site by URL
        driver.navigate().to(url);

        //Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //Perform login
        WebElement loginButtonInDropdown = driver.findElement(By.className(
                ".uui-profile-menu .caret"));
        loginButtonInDropdown.click();

        WebElement loginInput = driver.findElement(By.id("name"));
        loginInput.sendKeys(login);
        WebElement passInput = driver.findElement(By.id("password"));
        passInput.sendKeys(password);
        WebElement enterButton = driver.findElement(By.className("fa-sign-in"));
        enterButton.click();

        //Assert Username is loggined
        WebElement username = driver.findElement(By.cssSelector("[ui=label]#user-name"));
        softAssert.assertEquals(username.getText(), "ROMAN IOVLEV");

        //Assert that there are 4 items on the header section are displayed and
        //they have proper texts "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        List<WebElement> collectionOfLinksInHeader =
                driver.findElements(By.cssSelector(".m-l8>li>a"));
        List<String> expectedTextFromLinksInHeader =
                new ArrayList<>(Arrays.asList(
                        "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
        List<String> textFromLinksInHeader = new ArrayList<>();
        for (WebElement elem : collectionOfLinksInHeader) {
            textFromLinksInHeader.add(elem.getText());
        }
        softAssert.assertEquals(textFromLinksInHeader, expectedTextFromLinksInHeader);


        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons =
                driver.findElements(By.className("benefit-icon"));
        for (WebElement pic : benefitIcons) {
            softAssert.assertTrue(pic.isDisplayed());
        }

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitTxts = driver.findElements(By.className("benefit-txt"));
        String expected1Txt = "To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project";
        String expected2Txt = "To be flexible and\n"
                + "customizable";
        String expected3Txt = "To be multiplatform";
        String expected4Txt = "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…";
        softAssert.assertEquals(benefitTxts.get(0).getText(), expected1Txt);
        softAssert.assertEquals(benefitTxts.get(1).getText(), expected2Txt);
        softAssert.assertEquals(benefitTxts.get(2).getText(), expected3Txt);
        softAssert.assertEquals(benefitTxts.get(3).getText(), expected4Txt);

        //Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = driver.findElement(By.id("frame"));
        iframe.isDisplayed();

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(iframe);
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        frameButton.isDisplayed();

        //Switch to original window back
        driver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftMenuItems =
                driver.findElements(By.cssSelector("#mCSB_1_container .sidebar-menu.left>li"));
        List<String> textFromLeftMenuItems = new ArrayList<>();
        for (WebElement item : leftMenuItems) {
            textFromLeftMenuItems.add(item.getText());
        }
        List<String> expectedTextFromLeftMenuItems = new ArrayList<>(Arrays.asList(
                "Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));
        softAssert.assertEquals(textFromLeftMenuItems, expectedTextFromLeftMenuItems);
    }

    @Test
    public void testEx2() {
        //Open test site by URL
        driver.navigate().to(url);

        //Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //Perform login TODO choose better selector
        WebElement loginButtonInDropdown = driver.findElement(By.className("uui-profile-menu"));
        loginButtonInDropdown.click();

        WebElement loginInput = driver.findElement(By.id("name"));
        loginInput.sendKeys(login);
        WebElement passInput = driver.findElement(By.id("password"));
        passInput.sendKeys(password);
        WebElement enterButton = driver.findElement(By.className("fa-sign-in"));
        enterButton.click();

        //Assert Username is loggined
        WebElement username = driver.findElement(By.cssSelector("[ui=label]#user-name"));
        softAssert.assertEquals(username.getText(), "ROMAN IOVLEV");

        //Open through the header menu Service -> Different Elements Page
        WebElement dropdownService = driver.findElement(By.cssSelector("header .dropdown"));
        dropdownService.click();
        List<WebElement> pagesInService = driver.findElements(By.cssSelector("header .dropdown a"));
        pagesInService.get(8).click();


        //Select checkboxes Water, Wind
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".checkbox-row input"));
        checkboxes.get(0).click();
        checkboxes.get(2).click();


        //Select radio Selen
        List<WebElement> radioButtons = driver
                .findElements(By.cssSelector(".checkbox-row .label-radio "));
        radioButtons.get(3).click();

        //Select in dropdown Yellow
        WebElement dropdown = driver.findElement(By.className("colors"));
        dropdown.click();
        List<WebElement> rowInDropdown = driver.findElements(By.cssSelector(".colors option"));
        rowInDropdown.get(3).click();

        //Assert that
        //for each checkbox there is an individual log row and value is corresponded
        // to the status of checkbox
        //for radio button there is a log row and value is corresponded
        // to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value. 
        List<WebElement> logRows = driver
                .findElements(By.cssSelector(".info-panel-body-log ul li"));
        int logIndexOfTextMessage = 1;
        int indexWater = 3;
        int indexWind = 2;
        int indexSelen = 1;
        int indexYellow = 0;
        String[] rowChkbxWater = logRows.get(indexWater).getText().split("(\\d+):(\\d+):(\\d+) ");
        String factRowChkbxWater = rowChkbxWater[logIndexOfTextMessage];
        String[] rowChkbxWind = logRows.get(indexWind).getText().split("(\\d+):(\\d+):(\\d+) ");
        String factRowChkbxWind = rowChkbxWind[logIndexOfTextMessage];
        String[] rowRadioSelen = logRows.get(indexSelen).getText().split("(\\d+):(\\d+):(\\d+) ");
        String factRowRadioSelen = rowRadioSelen[logIndexOfTextMessage];
        String[] rowDropdownYellow = logRows.get(indexYellow).getText()
                .split("(\\d+):(\\d+):(\\d+) ");
        String factRowDropdownYellow = rowDropdownYellow[logIndexOfTextMessage];

        softAssert.assertEquals(factRowChkbxWater, "Water: condition changed to true");
        softAssert.assertEquals(factRowChkbxWind, "Wind: condition changed to true");
        softAssert.assertEquals(factRowRadioSelen, "metal: value changed to Selen");
        softAssert.assertEquals(factRowDropdownYellow, "Colors: value changed to Yellow");



    }


}
