package ru.training.at.hw1;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestMultiply extends BaseTest {

    @Test
    public void testMultiply() {
        long a = 2;
        long b = 3;
        assertEquals(6, calculator.mult(a,b));
    }



}
