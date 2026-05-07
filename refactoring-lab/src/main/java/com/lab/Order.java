package com.lab;

import java.util.List;
import java.util.ArrayList;

public class Order {
    private Customer customer;
    private List<Item> items;

    public Order(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items != null ? items : new ArrayList<>();
    }

    public Customer getCustomer() { return customer; }
    public List<Item> getItems() { return items; }
}
