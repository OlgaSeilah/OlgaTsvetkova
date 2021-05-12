package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
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

    public void chooseCheckbox(String chckbxName) {
        switch (chckbxName) {
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
        }
    }

    public String getCuttedTextsFromLogWater() {
        int logIndexOfTextMessage = 1;
        int indexWater = 3;
        String[] rowChkbxWater = logRows.get(indexWater).getText().split("(\\d+):(\\d+):(\\d+) ");
        return rowChkbxWater[logIndexOfTextMessage];
    }

    public String getCuttedTextsFromLogWind() {
        int logIndexOfTextMessage = 1;
        int indexWind = 2;
        String[] rowChkbxWind = logRows.get(indexWind).getText().split("(\\d+):(\\d+):(\\d+) ");
        return rowChkbxWind[logIndexOfTextMessage];
    }

    public String getCuttedTextsFromLogSelen() {
        int logIndexOfTextMessage = 1;
        int indexSelen = 1;
        String[] rowRadioSelen = logRows.get(indexSelen).getText().split("(\\d+):(\\d+):(\\d+) ");
        return rowRadioSelen[logIndexOfTextMessage];
    }

    public String getCuttedTextsFromLogYellow() {
        int logIndexOfTextMessage = 1;
        int indexYellow = 0;
        String[] rowDropdownYellow = logRows.get(indexYellow).getText()
                .split("(\\d+):(\\d+):(\\d+) ");
        return rowDropdownYellow[logIndexOfTextMessage];
    }

    public DiffElementsPage(WebDriver driver) {
        super(driver);
    }
}
