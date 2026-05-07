package com.lab;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Calculator - written BEFORE the rename refactoring.
 * These tests define the expected behavior and must continue to pass
 * after variables and methods are renamed.
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void calc_withPositiveNumbers_returnsSumDividedByProduct() {
        // a=2, b=4 => sum=6, product=8 => 6/8 = 0.75
        double result = calculator.calc(2, 4);
        assertEquals(0.75, result, 1e-9);
    }

    @Test
    public void calc_withOneAndTwo_returnsExpectedRatio() {
        // sum=3, product=2 => 3/2 = 1.5
        double result = calculator.calc(1, 2);
        assertEquals(1.5, result, 1e-9);
    }

    @Test
    public void calc_withDecimalInputs_returnsCorrectResult() {
        double result = calculator.calc(2.0, 3.0);
        assertEquals(5.0 / 6.0, result, 1e-9);
    }

    @Test
    public void calc_withLargeNumbers_doesNotOverflow() {
        double result = calculator.calc(1000, 2000);
        assertEquals(3000.0 / 2_000_000.0, result, 1e-9);
    }

    @Test
    public void prtRes_doesNotThrow() {
        calculator.prtRes(42.0); // should print without throwing
    }
}
