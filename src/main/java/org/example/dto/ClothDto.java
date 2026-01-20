package org.example.dto;

import java.util.Objects;

public class ClothDto extends ItemDto{

    private int size;
    private String season;
    private String type;
    private String material;


    public ClothDto(String name, double price, String description, boolean inStock, int size, String season, String type, String material) {
        super(name, price, description, inStock);
        this.size = size;
        this.season = season;
        this.type = type;
        this.material = material;
    }

    public ClothDto() {
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
    public String toString() {
        return super.toString() + " | size: " + size + " | season " + season + " | type " + type + " | material " + material;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClothDto clothDto = (ClothDto) o;
        return size == clothDto.size && Objects.equals(season, clothDto.season) && Objects.equals(type, clothDto.type) && Objects.equals(material, clothDto.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, season, type, material);
    }
}