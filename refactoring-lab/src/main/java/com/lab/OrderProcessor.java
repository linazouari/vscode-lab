package com.lab;

import java.util.List;

/**
 * OrderProcessor - AFTER Extract Method Refactoring
 *
 * VS Code refactoring used: Extract Method
 *   The single long printOrderSummary() method was broken into:
 *     - calculateTotalPrice(List<Item>)
 *     - applyDiscount(double, boolean)
 *     - printSummary(Order, double)
 *     - printItems(List<Item>)
 */
public class OrderProcessor {

    public void printOrderSummary(Order order) {
        double totalPrice = calculateTotalPrice(order.getItems());
        totalPrice = applyDiscount(totalPrice, order.getCustomer().isMember());
        printSummary(order, totalPrice);
    }

    // Extracted method: calculates raw item total
    private double calculateTotalPrice(List<Item> items) {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    // Extracted method: applies member discount
    private double applyDiscount(double totalPrice, boolean isMember) {
        if (isMember) {
            return totalPrice * 0.9; // 10% discount for members
        }
        return totalPrice;
    }

    // Extracted method: prints the full summary
    private void printSummary(Order order, double totalPrice) {
        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        printItems(order.getItems());
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }

    // Extracted method: prints each line item
    private void printItems(List<Item> items) {
        System.out.println("Items:");
        for (Item item : items) {
            System.out.println("  - " + item.getName() + ": "
                    + item.getQuantity() + " x $" + item.getPrice()
                    + " = $" + (item.getQuantity() * item.getPrice()));
        }
    }

    /**
     * Public helper used by tests to verify computation without capturing stdout.
     */
    public double computeTotal(Order order) {
        double total = calculateTotalPrice(order.getItems());
        return applyDiscount(total, order.getCustomer().isMember());
    }
}
