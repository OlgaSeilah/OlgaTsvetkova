package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestMultiply {

    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                {  2, 3 },
                {  58, 579 },
                { -1, 1 }
        };
    }

    @Test (dataProvider = "ValidDataProvider")
    public void testMultiply(final long a, final long b) {
        assertEquals(a*b, calculator.mult(a,b));
    }


}
