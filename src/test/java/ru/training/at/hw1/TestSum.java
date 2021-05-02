package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class TestSum {

    Calculator calculator = new Calculator();

    @Test
    public void testSum() {
        long a = 2;
        long b = 3;
        assertEquals(calculator.sum(a,b), 5);
    }




}
