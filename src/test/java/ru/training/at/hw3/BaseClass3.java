package ru.training.at.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass3 {

    protected WebDriver driver;
    protected static final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String password = "Jdi1234";
    Properties testDataProps = null;


//    @BeforeMethod
//    public WebDriver setUpDriver() {
//
//        testDataProps  = DataProperties.getTestDataProps();
//
//        if (driver == null) {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-notifications", "--disable-popup-blocking");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts()
//                    .implicitlyWait(10, TimeUnit.SECONDS);
//        }
//        return driver;

//    }



//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
