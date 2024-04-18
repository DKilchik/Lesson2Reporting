package org.app;



import io.qameta.allure.*;
import io.qameta.allure.internal.shadowed.jackson.databind.AnnotationIntrospector;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

@Epic("Calculator")
@Owner("Orange Systems")
@Severity(SeverityLevel.CRITICAL)
public class TestCalculator{


        public int firstValue;
        public int secondValue;

        @BeforeTest(description = "Generating 2 random values")
        public void getRandomValues(){
        int min = 0;
        int max = 10;
        this.firstValue = ThreadLocalRandom.current().nextInt(min, max + 1);
        Allure.attachment("first value: ", String.valueOf(this.firstValue));
        this.secondValue = ThreadLocalRandom.current().nextInt(min, max + 1);
        Allure.attachment("second value: ",String.valueOf(this.secondValue));
        }

        @Test(description = "Addition")
        @Feature("Addition")
        @Description("Checking addition of 2 random values")
        public void testAddition() {
        // get reference data

        Allure.step("Getting expected result");
        int expectedResult = firstValue + secondValue;

        Calculator calculator = new Calculator(firstValue, '+', secondValue);
        Allure.step("Calculate actual result");
        double actualResult = calculator.calculate();
            Allure.step("Compare expected and actual result", step -> {
            Assert.assertEquals(actualResult,expectedResult,"Wrong addition result");
        });
    }

        @Test(description = "Subtraction")
        @Feature("Subtraction")
        @Description("Checking subtraction using 2 random values")
        public void testSubtraction() {
        // get reference data
        int expectedResult = firstValue - secondValue;

        Calculator calculator = new Calculator(firstValue, '-', secondValue);
        double actualResult = calculator.calculate();
        Assert.assertEquals(actualResult,expectedResult,"Wrong subtraction result");
    }
}
