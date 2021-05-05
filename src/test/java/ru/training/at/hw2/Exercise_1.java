package ru.training.at.hw2;

import com.epam.tat.module4.Calculator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Exercise_1 {
    Calculator calculator = new Calculator();

    @BeforeClass
    public void setup() {
        WebDriver driver = new ChromeDriver();



    }


}
