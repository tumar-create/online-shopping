package org.example.service;

import org.example.model.Customer;
import org.example.model.Item;
import org.example.model.Order;
import org.example.repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;

public class StoreService {

    private final StoreRepository repository;

    public StoreService() {
        this.repository = new StoreRepository();
    }

    public void addItem(Item item) {
        repository.saveItem(item);
    }

    public void saveCustomer(Customer customer) {
        repository.saveCustomer(customer);
    }

    public List<Item> getAllItems() {
        return repository.getAllItems();
    }

    public void createOrder(Customer customer, List<Integer> itemIds) {
        if (customer.getId() == 0) {
            repository.saveCustomer(customer);
        }

        List<Item> itemsForOrder = new ArrayList<>();

        for (Integer id : itemIds) {
            Item item = repository.findItemById(id);
            if (item != null && item.isInStock()) {
                itemsForOrder.add(item);
            } else {
                System.out.println("WARNING: Item ID " + id + " not found or not in stock!");
            }
        }

        if (itemsForOrder.isEmpty()) {
            System.out.println("Shopping cart is empty!!");
            return;
        }

        Order newOrder = new Order(customer, itemsForOrder, 0.0, 5.0, 15.0);

        double finalPrice = calculateFinalTotal(newOrder);
        newOrder.setTotalAmount(finalPrice);

        repository.saveOrder(newOrder);

        System.out.println("Order saved in db.");
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
        for (Item i : order.getItems()) {
            System.out.println(i.toString());;
        }
        System.out.println("----------------------");
        System.out.println("Items price: " + calculateItemsTotal(order));
        System.out.println("Discount: " + order.getDiscount());
        System.out.println("Shipping cost: " +  order.getShippingCost());
        System.out.println("Final total price: " + calculateFinalTotal(order));
        System.out.println("============================================\n");
    }

    public void showInventory() {
        List<Item> items = repository.getAllItems();
        for (Item item : items) {
            item.showInfo();
        }
    }

    public List<Item> searchByName(String name) {
        List<Item> all = repository.getAllItems();
        List<Item> result = new ArrayList<>();
        for (Item item : all) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }
}