package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Item;
import org.example.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class StoreService {

    private List<Item> inventory;
    private List<Order> orders;

    // auto generation order id
    private int orderIdCounter = 1;

    public StoreService() {
        this.inventory = new ArrayList<>();
        this.orders = new ArrayList<>();
    }


    public void createOrder(Customer customer, List<Integer> itemIds) {
        List<Item> itemsForOrder = new ArrayList<>();

        for (Integer id : itemIds) {
            Item item = findById(id);
            if (item != null) {
                if (item.isInStock()) {
                    itemsForOrder.add(item);
                } else {
                    System.out.println("Item:" + item.getName() + " (ID: " + id + ") is not available.");
                }
            } else {
                System.out.println("Item with id: " + id + " not found!");
            }
        }

        if (itemsForOrder.isEmpty()) {
            System.out.println("Shopping cart is empty!");
            return;
        }

        int currentId = orderIdCounter++;
        Order newOrder = new Order(currentId, customer, itemsForOrder, 0.0, 5.0, 1500.0);

        double finalTotal = calculateFinalTotal(newOrder);
        newOrder.setTotalAmount(finalTotal);

        orders.add(newOrder);

        printOrderDetails(newOrder);
    }


    public double calculateItemsTotal(Order order) {
        double sum = 0;
        if (order.getItems() != null) {
            for (Item i : order.getItems()) {
                sum += i.getPrice();
            }
        }
        return sum;
    }

    public double calculateFinalTotal(Order order) {
        double itemsTotal = calculateItemsTotal(order);
        double discountAmount = itemsTotal * (order.getDiscount() / 100.0);
        return itemsTotal - discountAmount + order.getShippingCost();
    }

    public void printOrderDetails(Order order) {
        System.out.println("\n============== ORDER RECEIPT#" + order.getId() + " ==============");
        System.out.println("Customer: " + order.getCustomer().getFullName());
        System.out.println("--- Item List ---");
        for (Item item : order.getItems()) {
            System.out.println(item.toString());
        }
        System.out.println("----------------------");
        System.out.println("Items price: " + calculateItemsTotal(order));
        System.out.println("Discount: " + order.getDiscount());
        System.out.println("Shipping cost: " +  order.getShippingCost());
        System.out.println("Final total price: " + calculateFinalTotal(order));
        System.out.println("============================================\n");
    }



    public void addItem(Item item) {
        if (findById(item.getId()) != null) {
            System.out.println("Item with ID: " + item.getId() + " already exists");
            return;
        }
        inventory.add(item);
    }

    public void deleteItem(int id) {
        Item itemToRemove = findById(id);

        if(itemToRemove != null) {
            inventory.remove(itemToRemove);
            System.out.println("Item with id: " + id + " was deleted.");
        }

    }

    public Item findById(int id) {
        for (Item item : inventory) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<Item> searchByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : inventory) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    public List<Item> filterByPriceRange(double min, double max) {
        List<Item> result = new ArrayList<>();
        for (Item item : inventory) {
            if (item.getPrice() >= min && item.getPrice() <= max) {
                result.add(item);
            }
        }
        return result;
    }


    public void sortByName() {
        for (int i = 0; i < inventory.size() - 1; i++) {
            for (int j = 0; j < inventory.size() - i - 1; j++) {
                Item item1 = inventory.get(j);
                Item item2 = inventory.get(j + 1);
                if (item1.getName().compareTo(item2.getName()) > 0) {
                    inventory.set(j, item2);
                    inventory.set(j + 1, item1);
                }
            }
        }
    }

    public void showInventory() {
        System.out.println("--- All items ---");
        for (Item item : inventory) {
            System.out.println(item);
        }
    }
}