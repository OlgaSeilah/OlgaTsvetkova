package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;

public class SetupClass {

    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {  2, 3 },
                {  52, 43 },
                { 33, -7 }
        };
    }
}
