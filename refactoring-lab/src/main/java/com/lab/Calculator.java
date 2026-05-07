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

    public double calculateSumProductRatio(double num1, double num2) {
        double sum = num1 + num2;
        double product = num1 * num2;
        return sum / product;
    }

    public void printResult(double result) {
        System.out.println("Result: " + result);
    }

    // Bridge methods so existing tests remain green after rename
    /** @deprecated use calculateSumProductRatio */
    @Deprecated
    public double calc(double a, double b) {
        return calculateSumProductRatio(a, b);
    }

    /** @deprecated use printResult */
    @Deprecated
    public void prtRes(double res) {
        printResult(res);
    }
}
