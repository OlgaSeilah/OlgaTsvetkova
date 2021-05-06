package ru.training.at.hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestSum extends SetupClass {

    @Test (dataProviderClass = DataProviders.class,
            dataProvider = "validNumbers")
    public void testSum(final long a, final long b) {
        assertEquals(a + b, calculator.sum(a, b));
    }

}
