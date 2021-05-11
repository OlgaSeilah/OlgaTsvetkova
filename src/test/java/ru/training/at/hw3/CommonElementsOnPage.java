package ru.training.at.hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElementsOnPage extends BasePage {

    //TODO Почему протектед??
    @FindBy(css = ".uui-profile-menu .caret")
    protected WebElement loginButtonInDropdown;

    @FindBy(id = "name")
    protected WebElement loginInput;

    @FindBy(id = "password")
    protected WebElement passwordInput;

    @FindBy(className = "fa-sign-in")
    protected WebElement enterButton;

    @FindBy(id = "user-name")
    WebElement loggedUserName;



    public CommonElementsOnPage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedUserName() {
        return loggedUserName.getText();
    }
}
