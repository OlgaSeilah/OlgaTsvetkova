package ru.training.at.hw2;


import com.epam.tat.module4.Calculator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise_1 {

    @Test
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Seilah/IdeaProjects/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

    }


}
