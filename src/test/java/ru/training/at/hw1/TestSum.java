package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestSum {

    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                {  2, 3 },
                {  52, 43 },
                { 33, -7 }
        };
    }

    @Test (dataProvider = "ValidDataProvider")
    public void testSum(final long a, final long b) {
        assertEquals(a+b, calculator.sum(a,b));
    }




}
