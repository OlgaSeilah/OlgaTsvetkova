package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DiffElementsPage extends CommonElementsOnPage {

    @FindBy(css = ".info-panel-body-log ul li")
    List<WebElement> logRows;

    @FindBy(css = ".checkbox-row input")
    List<WebElement> checkboxes;

    @FindBy(css = ".checkbox-row .label-radio ")
    List<WebElement> radiobuttons;

    @FindBy(className = "colors")
    WebElement dropdown;

    @FindBy(css = ".colors option")
    List<WebElement> colorsInDropdown;

    public void chooseRadiobutton(String rbName) {
        switch (rbName) {
            case "Gold":
                radiobuttons.get(0).click();
                break;
            case "Silver":
                radiobuttons.get(1).click();
                break;
            case "Bronze":
                radiobuttons.get(2).click();
                break;
            case "Selen":
                radiobuttons.get(3).click();
                break;
            default:
                System.out.println("There isn't that text on the page");
        }
    }

    public void chooseColorInDropdown(String colorName) {
        dropdown.click();
        switch (colorName) {
            case "Red":
                colorsInDropdown.get(0).click();
                break;
            case "Green":
                colorsInDropdown.get(1).click();
                break;
            case "Blue":
                colorsInDropdown.get(2).click();
                break;
            case "Yellow":
                colorsInDropdown.get(3).click();
                break;
            default:
                System.out.println("There isn't that text on the page");
        }
    }

    public void chooseChk(String box) {
        switch (box) {
            case "Water":
                checkboxes.get(0).click();
                break;
            case "Earth":
                checkboxes.get(1).click();
                break;
            case "Wind":
                checkboxes.get(2).click();
                break;
            case "Fire":
                checkboxes.get(3).click();
                break;
            default:
                System.out.println("There isn't that text on the page");
                break;
        }
    }

    public String getCuttedTextFromLog() {
        String[] splitRow = logRows.get(0).getText()
                .split("(\\d+):(\\d+):(\\d+) ");
        return splitRow[1];
    }

    public DiffElementsPage(WebDriver driver) {
        super(driver);
    }
}
