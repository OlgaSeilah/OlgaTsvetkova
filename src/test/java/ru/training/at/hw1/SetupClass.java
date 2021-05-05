package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public abstract class SetupClass {

    public Calculator calculator;

    @BeforeMethod
    public void createCalc() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {  2, 3 },
                {  52, 43 },
                { 33, -7 }
        };
    }

    @AfterMethod
    public void delCalc() {
        calculator = null;
    }
}
