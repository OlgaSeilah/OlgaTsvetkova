package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsOnPage extends BasePage {

    @FindBy(css = ".uui-profile-menu .caret")
    WebElement loginButtonInDropdown;

    @FindBy(id = "name")
    WebElement loginInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(className = "fa-sign-in")
    WebElement enterButton;

    @FindBy(id = "user-name")
    WebElement loggedUserName;

    @FindBy(css = ".m-l8>li>a")
    List<WebElement> collectionOfLinksInHeader;

    @FindBy(css = "header .dropdown")
    WebElement dropdownService;

    @FindBy(css = "header .dropdown a")
    List<WebElement> pointsInMenuService;

    public CommonElementsOnPage(WebDriver driver) {
        super(driver);
    }

    public void openHeaderMenuService() {
        dropdownService.click();
    }

    public List<String> getPointsInMenuServiceTxts() {
        List<String> pointsInMenuServiceTxts = new ArrayList<>();
        for (WebElement elem : pointsInMenuService) {
            pointsInMenuServiceTxts.add(elem.getText());
        }
        return pointsInMenuServiceTxts;
    }

    public void openPointInMenuService(String pointName) {
        switch (pointName) {
            case "Support":
                pointsInMenuService.get(0).click();
                break;
            case "Dates":
                pointsInMenuService.get(1).click();
                break;
            case "Search":
                pointsInMenuService.get(2).click();
                break;
            case "Complex Table":
                pointsInMenuService.get(3).click();
                break;
            case "Simple Table":
                pointsInMenuService.get(4).click();
                break;
            case "Different Elements Page":
                pointsInMenuService.get(8).click();
                break;
            default:
                System.out.println("There isn't that text on the page");

        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getLoggedUserName() {
        return loggedUserName.getText();
    }

    public List<String> getCollectionOfLinksTextsInHeader() {
        List<String> textFromLinksInHeader = new ArrayList<>();
        for (WebElement elem : collectionOfLinksInHeader) {
            textFromLinksInHeader.add(elem.getText());
        }
        return textFromLinksInHeader;
    }
}
