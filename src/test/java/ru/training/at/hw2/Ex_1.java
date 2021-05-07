package ru.training.at.hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Ex_1 extends BaseClass {

    @Test
    public void testEx1() {
        //Open URL
        driver.navigate().to(url);

        //Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //Perform login TODO choose better selector
        WebElement loginButtonInDropdown = driver.findElement(By.className("uui-profile-menu"));
        loginButtonInDropdown.click();

        WebElement loginInput = driver.findElement(By.id("#name"));
        loginInput.sendKeys(login);
        WebElement passInput = driver.findElement(By.id("#password"));
        passInput.sendKeys(password);
        WebElement enterButton = driver.findElement(By.className(".fa-sign-in"));
        enterButton.click();

        WebElement username = driver.findElement(By.cssSelector("[ui=label]#user-name"));
        assertEquals(username.getText(), "ROMAN IOVLEV");





    }

}
