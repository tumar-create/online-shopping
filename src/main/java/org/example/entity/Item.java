package org.example.entity;

public abstract class Item {

    private int id;
    private String name;
    private double price;
    private String description;
    private boolean inStock;


    public Item() {
    }

    public Item(int id, String name, double price, String description, boolean inStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.inStock = inStock;
    }

    public abstract void showInfo();



    public boolean hasSameName(Item other) {
        return this.name != null && this.name.equals(other.name);
    }

    public boolean isCheaperThan(Item other) {
        return this.price < other.price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | name: " + name + "  | description: " + description
                + " | price: " + price + " | inStock?: " + inStock;
    }
}