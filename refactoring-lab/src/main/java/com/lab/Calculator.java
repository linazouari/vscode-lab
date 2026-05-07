package com.lab;

/**
 * Calculator - AFTER Rename Refactoring
 *
 * VS Code refactoring used: Rename Symbol (F2)
 *   calc   -> calculateSumProductRatio
 *   prtRes -> printResult
 *   a, b   -> num1, num2
 *   x      -> sum
 *   y      -> product
 */

public class Calculator {

    public double calc(double a, double b) {
        double x = a + b;
        double y = a * b;
        return x / y;
    }

    public void prtRes(double res) {
        System.out.println("Result: " + res);
    }
}
