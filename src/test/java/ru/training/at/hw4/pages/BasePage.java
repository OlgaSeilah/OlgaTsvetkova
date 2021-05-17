package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw4.utils.DataProperties;

import java.util.Properties;

public class BasePage {
    WebDriver driver;
    Properties properties = null;

    public String getUrlFromProps() {
        properties = DataProperties.getTestDataProps();
        return properties.getProperty("url");
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
