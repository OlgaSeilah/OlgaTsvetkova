package ru.training.at.hw4.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.training.at.hw4.test.BaseTest;


public class ScreenshotsListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("This test is failed. Taking a screenshot");

        try {
            doScreenshot(((BaseTest) result.getInstance()).getDriver());
        } catch (NullPointerException npe) {
            System.out.println("Driver not found");
        }
    }


    @Attachment(type = "image/png", fileExtension = "png")
    private byte[] doScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
