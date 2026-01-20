package org.example.dto;

import java.util.Objects;

public class PhoneDto extends ItemDto{

    private String brand;
    private String model;
    private String color;
    private int memory;

    public PhoneDto(String name, double price, String description, boolean inStock, String brand, String model, String color, int memory) {
        super(name, price, description, inStock);
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.memory = memory;
    }

    public PhoneDto() {}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
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
    public String toString() {
        return "PhoneDto{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", memory=" + memory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PhoneDto phoneDto = (PhoneDto) o;
        return memory == phoneDto.memory && Objects.equals(brand, phoneDto.brand) && Objects.equals(model, phoneDto.model) && Objects.equals(color, phoneDto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand, model, color, memory);
    }
}