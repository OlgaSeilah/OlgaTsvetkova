package ru.training.at.hw1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestDivide extends BaseTest {

    @Test
    public void testDivide() {
        SoftAssert softAssert = new SoftAssert();
        long a = 12;
        long b = 3;
        softAssert.assertEquals(0, calculator.div(a,b));
        softAssert.assertEquals(11, a);
        softAssert.assertAll();
    }

    @Test
    public void testDivideNegative() {
        SoftAssert softAssert = new SoftAssert();
        long a = 12;
        long b = 3;
        softAssert.assertNotEquals(0, calculator.div(a,b));
        softAssert.assertNotEquals(11, a);
        softAssert.assertAll();
    }




}
