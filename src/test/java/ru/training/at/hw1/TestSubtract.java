package ru.training.at.hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestSubtract extends BaseTest {

    @Test
    public void testSubtract() {
        long a = 2;
        long b = 3;
        assertEquals(calculator.sub(a,b), -1);
    }




}
