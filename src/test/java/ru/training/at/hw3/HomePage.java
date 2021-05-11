package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonElementsOnPage {

    // 4 картинки внизу страницы
    @FindBy(css = ".benefit-icon")
    List<WebElement> benefitIcons;

    // 4 надписи под картинками внизу страницы
    //(By.className("benefit-txt"));
    @FindBy(css = ".benefit-txt")
    List<WebElement> benefitTxts;

    @FindBy(css = ".main-txt")
    WebElement mainTextInCenter;

    @FindBy(css = "h3.main-title")
    WebElement headerInCenter;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openSite() {
        driver.navigate().to(url);
    }

    public String getLoggedUserName() {
        return loggedUserName.getText();
    }

    public void performLogin(String login, String password) {
        loginButtonInDropdown.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        enterButton.click();
    }






}
