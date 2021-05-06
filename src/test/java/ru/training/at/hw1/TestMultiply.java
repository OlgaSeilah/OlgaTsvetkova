package ru.training.at.hw1;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestMultiply extends SetupClass {

    @Test (dataProviderClass = DataProviders.class,
            dataProvider = "validNumbers")
    public void testMultiply(final long a, final long b) {
        assertEquals(a * b, calculator.mult(a, b));
    }


}
