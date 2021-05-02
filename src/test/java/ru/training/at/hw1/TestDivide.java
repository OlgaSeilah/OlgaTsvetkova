package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestDivide {

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
    public void testDivide(final long a, final long b) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(a/b, calculator.div(a,b));
        softAssert.assertEquals(12, a);
        softAssert.assertAll();
    }

    @Test (dataProvider = "ValidDataProvider")
    public void testDivideNegative(final long a, final long b) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(a/b, calculator.div(a,b));
        softAssert.assertNotEquals(11, a);
        softAssert.assertAll();
    }

    @Test (expectedExceptions = {NumberFormatException.class})
    public void testDivideOnNull() {
        long a = 12;
        long b = 0;
        calculator.div(a, b);
    }






}
