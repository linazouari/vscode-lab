package com.lab;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrderProcessorTest {

    private OrderProcessor processor;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @Before
    public void setUp() {
        processor = new OrderProcessor();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void printOrderSummary_containsCustomerName() {
        Customer customer = new Customer("Alice", false);
        List<Item> items = Arrays.asList(new Item("Book", 20.0, 2));
        Order order = new Order(customer, items);
        processor.printOrderSummary(order);
        assertTrue(outContent.toString().contains("Alice"));
    }

    @Test
    public void printOrderSummary_containsOrderSummaryHeader() {
        Customer customer = new Customer("Bob", false);
        List<Item> items = Arrays.asList(new Item("Pen", 2.0, 3));
        Order order = new Order(customer, items);
        processor.printOrderSummary(order);
        assertTrue(outContent.toString().contains("Order Summary:"));
    }

    @Test
    public void printOrderSummary_nonMember_showsCorrectTotal() {
        Customer customer = new Customer("Carol", false);
        List<Item> items = Arrays.asList(new Item("Widget", 10.0, 5));
        Order order = new Order(customer, items);
        processor.printOrderSummary(order);
        assertTrue(outContent.toString().contains("50.00"));
    }

    @Test
    public void printOrderSummary_member_showsDiscountedTotal() {
        Customer customer = new Customer("Dave", true);
        List<Item> items = Arrays.asList(new Item("Gadget", 100.0, 1));
        Order order = new Order(customer, items);
        processor.printOrderSummary(order);
        assertTrue(outContent.toString().contains("90.00"));
    }

    @Test
    public void printOrderSummary_containsItemName() {
        Customer customer = new Customer("Eve", false);
        List<Item> items = Arrays.asList(new Item("Bicycle", 200.0, 1));
        Order order = new Order(customer, items);
        processor.printOrderSummary(order);
        assertTrue(outContent.toString().contains("Bicycle"));
    }
}