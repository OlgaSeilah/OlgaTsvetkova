package ru.training.at.hw1;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestDivide extends SetupClass {

    @Test (dataProvider = "validDataProvider")
    public void testDivide(final long a, final long b) {
        assertEquals(a / b, calculator.div(a, b));
    }

    @Test (expectedExceptions = {NumberFormatException.class})
    public void testDivideOnNull() {
        long a = 12;
        long b = 0;
        calculator.div(a, b);
    }

}
