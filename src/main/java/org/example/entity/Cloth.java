package org.example.entity;

import java.util.Objects;

public class Cloth extends Item {
    private int size;
    private String season;
    private String type;
    private String material;

    public Cloth(int id, String name, double price, String description, boolean inStock, int size, String season, String type, String material) {
        super(id, name, price, description, inStock);
        this.size = size;
        this.season = season;
        this.type = type;
        this.material = material;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void showInfo() {
        System.out.println("It's Cloth:");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " | size: " + size + " | season " + season + " | type " + type + " | material " + material;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cloth cloth = (Cloth) o;
        return size == cloth.size && Objects.equals(season, cloth.season) && Objects.equals(type, cloth.type) && Objects.equals(material, cloth.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, season, type, material);
    }
}