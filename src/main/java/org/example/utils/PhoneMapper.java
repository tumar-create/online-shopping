package org.example.utils;


import org.example.dto.PhoneDto;
import org.example.entity.PhoneEntity;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {
    public PhoneDto toDto(PhoneEntity entity) {
        if (entity == null) return null;
        PhoneDto dto = new PhoneDto(
                entity.getName(), entity.getPrice(), entity.getDescription(),
                entity.isInStock(), entity.getBrand(), entity.getModel(),
                entity.getColor(), entity.getMemory()
        );
        dto.setId(entity.getId());
        return dto;
    }

    public PhoneEntity toEntity(PhoneDto dto) {
        if (dto == null) return null;
        PhoneEntity entity = new PhoneEntity(
                dto.getName(), dto.getPrice(), dto.getDescription(),
                dto.isInStock(), dto.getBrand(), dto.getModel(),
                dto.getColor(), dto.getMemory()
        );
        entity.setId(dto.getId());
        return entity;
    }
}