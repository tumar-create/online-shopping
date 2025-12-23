package org.example.entity;

import java.util.Objects;

public class Phone extends Item {
    private String brand;
    private String model;
    private String color;
    private int memory;


    public Phone(int id, String name, double price, String description, boolean inStock, String brand, String model, String color, int memory) {
        super(id, name, price, description, inStock);
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.memory = memory;
    }


    public String getMarka() {
        return brand;
    }

    public void setMarka(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public void showInfo() {
        System.out.println("It's Phone:");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " | brand: " + brand + " | model: " + model + " | color: " + color + " | memory: " + memory;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return memory == phone.memory && Objects.equals(brand, phone.brand) && Objects.equals(model, phone.model) && Objects.equals(color, phone.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, color, memory);
    }
}