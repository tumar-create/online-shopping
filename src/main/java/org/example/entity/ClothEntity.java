package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;


@Entity
@Table(name = "cloths")
public class ClothEntity extends ItemEntity {

    private int size;
    private String season;
    private String type;
    private String material;

    public ClothEntity(String name, double price, String description, boolean inStock, int size, String season, String type, String material) {
        super(name, price, description, inStock);
        this.size = size;
        this.season = season;
        this.type = type;
        this.material = material;
    }

    public ClothEntity() {
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
        ClothEntity clothEntity = (ClothEntity) o;
        return size == clothEntity.size && Objects.equals(season, clothEntity.season) && Objects.equals(type, clothEntity.type) && Objects.equals(material, clothEntity.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, season, type, material);
    }
}