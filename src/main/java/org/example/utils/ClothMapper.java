package org.example.utils;


import org.example.dto.ClothDto;
import org.example.entity.ClothEntity;
import org.springframework.stereotype.Component;

@Component
public class ClothMapper {
    public ClothDto toDto(ClothEntity entity) {
        if (entity == null) return null;
        ClothDto dto = new ClothDto(
                entity.getName(), entity.getPrice(), entity.getDescription(),
                entity.isInStock(), entity.getSize(), entity.getSeason(),
                entity.getType(), entity.getMaterial()
        );
        dto.setId(entity.getId());
        return dto;
    }

    public ClothEntity toEntity(ClothDto dto) {
        if (dto == null) return null;
        ClothEntity entity = new ClothEntity(
                dto.getName(), dto.getPrice(), dto.getDescription(),
                dto.isInStock(), dto.getSize(), dto.getSeason(),
                dto.getType(), dto.getMaterial()
        );
        entity.setId(dto.getId());
        return entity;
    }
}