package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UserTablePage extends BasePage{

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "tbody td select")
    private List<WebElement> numberTypesDropdowns;

    @FindBy(css = "tbody tr:first-child td select option")
    private List<WebElement> itemsInDropdownRoman;

    @FindBy(css = "tbody tr td a")
    private List<WebElement> userNames;

    @FindBy(css = "tbody tr td div span")
    private List<WebElement> imageDescriptionText;

    @FindBy(css = "tbody tr td input[type=\"checkbox\"]")
    private List<WebElement> userCheckboxes;

    @FindBy(css = "tbody tr td:first-child")
    private List<WebElement> numbers;

    public List<WebElement> getUserCheckboxes() {
        return userCheckboxes;
    }

    public List<WebElement> getImageDescriptionText() {
        return imageDescriptionText;
    }

    public List<String> getTextItemsInDropdownRoman() {
        List<String> textItemsInDropdownRoman = new ArrayList<>();
        for (WebElement elem : itemsInDropdownRoman) {
            textItemsInDropdownRoman.add(elem.getText());
        }
        return textItemsInDropdownRoman;
    }

    public List<WebElement> getNumberTypesDropdowns() {
        return numberTypesDropdowns;
    }

    public List<WebElement> getUserNames() {
        return userNames;
    }

    public String getNumbersText(int i) {
        return numbers.get(i).getText();
    }

    public String getNamesText(int i) {
        return userNames.get(i).getText();
    }

    public String getImageDescriptionText(int i) {
        return imageDescriptionText.get(i).getText().
                replace("\n", " ");
    }

    public String getDropdownOptionsText(int i) {
        return numberTypesDropdowns.get(i).getText();
    }

    public void clickOnDropdownRomanToOpen() {
        numberTypesDropdowns.get(0).click();
    }

}
