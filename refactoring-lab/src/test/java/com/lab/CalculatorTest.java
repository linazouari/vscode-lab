package com.lab;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void calc_withPositiveNumbers_returnsSumDividedByProduct() {
        double result = calculator.calc(2, 4);
        assertEquals(0.75, result, 1e-9);
    }

    @Test
    public void calc_withOneAndTwo_returnsExpectedRatio() {
        double result = calculator.calc(1, 2);
        assertEquals(1.5, result, 1e-9);
    }

    @Test
    public void prtRes_doesNotThrow() {
        calculator.prtRes(42.0);
    }
}
