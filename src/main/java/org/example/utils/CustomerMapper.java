package org.example.utils;


import org.example.dto.CustomerDto;
import org.example.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto toDto(CustomerEntity entity) {
        if (entity == null) return null;
        CustomerDto dto = new CustomerDto(
                entity.getFullName(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getPhoneNumber()
        );
        dto.setId(entity.getId());
        return dto;
    }

    public CustomerEntity toEntity(CustomerDto dto) {
        if (dto == null) return null;
        CustomerEntity entity = new CustomerEntity(
                dto.getFullName(),
                dto.getEmail(),
                dto.getAddress(),
                dto.getPhoneNumber()
        );
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        return entity;
    }
}