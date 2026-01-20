package org.example.entity;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @SequenceGenerator(name = "item_seq", sequenceName = "item_global_sequence", allocationSize = 1)
    private Integer id;

    private String name;
    private double price;
    private String description;
    private boolean inStock;


    public ItemEntity() {
    }

    public ItemEntity(String name, double price, String description, boolean inStock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.inStock = inStock;
    }

    public abstract void showInfo();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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