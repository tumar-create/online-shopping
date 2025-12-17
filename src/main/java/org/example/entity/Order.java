package org.example.entity;

public class Order {

    private int id;
    private Customer customer;
    private Item[] items;
    private double totalAmount;
    private double discount;
    private double shippingCost;

    public Order() {
    }

    public Order(int id, Customer customer, Item[] items,
                 double totalAmount, double discount, double shippingCost) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.shippingCost = shippingCost;
    }

    public double calculateItemsTotal() {
        double sum = 0;
        if (items != null) {
            for (Item i : items) {
                sum += i.getPrice();
            }
        }
        return sum;
    }

    public double calculateFinalTotal() {
        double itemsTotal = calculateItemsTotal();
        double discountAmount = itemsTotal * (discount / 100.0);
        return itemsTotal - discountAmount + shippingCost;
    }

    public void printOrderDetails() {
        System.out.println("==============");
        System.out.println("Order ID: " + id);
        System.out.println("Customer information:");
        customer.printDetails();
        System.out.println("Items total: " + calculateItemsTotal());
        System.out.println("Discount: " + discount + "%");
        System.out.println("Shipping cost: " + shippingCost);
        System.out.println("Final total: " + calculateFinalTotal());
        System.out.println("==============");
    }

    public void showAllItems() {
        System.out.println("Items in order " + id + ":");
        if (items != null) {
            for (Item i : items) {
                System.out.println(i.toString());
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", items=" + (items == null ? null : items.length + " items") +
                ", totalAmount=" + totalAmount +
                ", discount=" + discount +
                ", shippingCost=" + shippingCost +
                '}';
    }
}