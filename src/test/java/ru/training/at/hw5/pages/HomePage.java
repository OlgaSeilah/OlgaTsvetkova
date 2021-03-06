package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonElementsOnPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".benefit-icon")
    List<WebElement> benefitIcons;

    @FindBy(css = ".benefit-txt")
    List<WebElement> benefitTxts;

    @FindBy(id = "frame")
    WebElement iframe;

    @FindBy(id = "frame-button")
    WebElement frameButton;

    @FindBy(css = "#mCSB_1_container .sidebar-menu.left>li")
    List<WebElement> leftMenuItems;


    public void openSite() {
        driver.navigate().to(getUrlFromProps());
    }

    public String getLoggedUserName() {
        return loggedUserName.getText();
    }

    public WebElement getIframe() {
        return iframe;
    }

    public void performLogin(String login, String password) {
        loginButtonInDropdown.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        enterButton.click();
    }

    public List<WebElement> getBenefitIcons() {
        return benefitIcons;
    }

    public List<String> getBenefitTxts() {
        List<String> benefitTxtsStrings = new ArrayList<>();
        for (WebElement txts : benefitTxts) {
            benefitTxtsStrings.add(txts.getText());
        }
        return benefitTxtsStrings;
    }

    public List<String> getLeftMenuItemsTxts() {
        List<String> leftMenuItemsTxts = new ArrayList<>();
        for (WebElement txts : leftMenuItems) {
            leftMenuItemsTxts.add(txts.getText());
        }
        return leftMenuItemsTxts;
    }








}
