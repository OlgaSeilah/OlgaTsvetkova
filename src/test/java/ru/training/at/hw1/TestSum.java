package ru.training.at.hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestSum extends SetupClass {

    @Test (dataProvider = "validDataProvider")
    public void testSum(final long a, final long b) {
        assertEquals(a + b, calculator.sum(a, b));
    }

}
