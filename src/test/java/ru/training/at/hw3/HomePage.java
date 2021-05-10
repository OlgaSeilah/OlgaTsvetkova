package ru.training.at.hw3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//*[@class='benefit-icon'][1]")
    WebElement displayedBenefitImage1;


}
