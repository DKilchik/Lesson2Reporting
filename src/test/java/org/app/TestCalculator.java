package org.app;



import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;


public class TestCalculator{


        public int firstValue;
        public int secondValue;

        @BeforeTest
        public void getRandomValues(){
        int min = 0;
        int max = 10;
        this.firstValue = ThreadLocalRandom.current().nextInt(min, max + 1);
        this.secondValue = ThreadLocalRandom.current().nextInt(min, max + 1);
        }

        @Test
        public void testAddition() {
        // get reference data
        int expectedResult = firstValue + secondValue;

        Calculator calculator = new Calculator(firstValue, '+', secondValue);
        double actualResult = calculator.calculate();
        Assert.assertEquals(actualResult,expectedResult,"Wrong addition result");
    }

        @Test
        public void testSubtraction() {
        // get reference data
        int expectedResult = firstValue - secondValue;

        Calculator calculator = new Calculator(firstValue, '-', secondValue);
        double actualResult = calculator.calculate();
        Assert.assertEquals(actualResult,expectedResult,"Wrong subtraction result");
    }
}
