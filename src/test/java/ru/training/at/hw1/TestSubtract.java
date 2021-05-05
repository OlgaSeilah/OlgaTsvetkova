package ru.training.at.hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestSubtract extends SetupClass {

    @Test (dataProvider = "validDataProvider")
    public void testSubtract(final long a, final long b) {
        assertEquals(a - b, calculator.sub(a, b));
    }

}
