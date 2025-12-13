package org.example.entity;

public class Order {

    private int id;
    private Customer customer;
    private Item item;
    private double totalAmount;
    private double discount;
    private double shippingCost;

    public Order() {
    }

    public Order(int id, Customer customer, Item item, double totalAmount, double discount, double shippingCost) {
        this.id = id;
        this.customer = customer;
        this.item = item;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.shippingCost = shippingCost;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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


    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", item=" + item +
                ", totalAmount=" + totalAmount +
                ", discount=" + discount +
                ", shippingCost=" + shippingCost +
                '}';
    }
}
