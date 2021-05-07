package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "validNumbers", parallel = true)
    public static Object[][] validNumbers() {
        return new Object[][]{
                {9676, 907987},
                {78, 568},
                {-24, 87678}};
    }

}
