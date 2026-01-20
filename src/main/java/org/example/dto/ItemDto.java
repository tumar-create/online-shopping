package org.example.dto;

import java.util.Objects;

public abstract class ItemDto {

    private Integer id;
    private String name;
    private double price;
    private String description;
    private boolean inStock;


    public ItemDto() {
    }

    public ItemDto(String name, double price, String description, boolean inStock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.inStock = inStock;
    }

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemDto itemDto = (ItemDto) o;
        return id == itemDto.id && Double.compare(price, itemDto.price) == 0 && inStock == itemDto.inStock && Objects.equals(name, itemDto.name) && Objects.equals(description, itemDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, inStock);
    }
}