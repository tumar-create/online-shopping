package org.example.utils;


import org.example.dto.ClothDto;
import org.example.dto.ItemDto;
import org.example.dto.OrderDto;
import org.example.dto.PhoneDto;
import org.example.entity.ClothEntity;
import org.example.entity.ItemEntity;
import org.example.entity.OrderEntity;
import org.example.entity.PhoneEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    private final CustomerMapper customerMapper;
    private final PhoneMapper phoneMapper;
    private final ClothMapper clothMapper;

    public OrderMapper(CustomerMapper customerMapper, PhoneMapper phoneMapper, ClothMapper clothMapper) {
        this.customerMapper = customerMapper;
        this.phoneMapper = phoneMapper;
        this.clothMapper = clothMapper;
    }

    public OrderDto toDto(OrderEntity entity) {
        if (entity == null) return null;
        OrderDto dto = new OrderDto(
                customerMapper.toDto(entity.getCustomer()),
                itemMapperToList(entity.getItems()),
                entity.getTotalAmount(),
                entity.getDiscount(),
                entity.getShippingCost()
        );
        dto.setId(entity.getId());
        return dto;
    }

    public OrderEntity toEntity(OrderDto dto) {
        if (dto == null) return null;
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setCustomer(customerMapper.toEntity(dto.getCustomerDto()));
        entity.setItems(itemDtoMapperToList(dto.getItems()));
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setDiscount(dto.getDiscount());
        entity.setShippingCost(dto.getShippingCost());
        return entity;
    }

    private List<ItemDto> itemMapperToList(List<ItemEntity> itemEntities) {
        if (itemEntities == null) return new ArrayList<>();

        List<ItemDto> list = new ArrayList<>();
        for (ItemEntity i : itemEntities) {
            if (i instanceof PhoneEntity) {
                list.add(phoneMapper.toDto((PhoneEntity) i));
            } else if (i instanceof ClothEntity) {
                list.add(clothMapper.toDto((ClothEntity) i));
            }
        }
        return list;
    }

    private List<ItemEntity> itemDtoMapperToList(List<ItemDto> items) {
        if (items == null) return new ArrayList<>();

        List<ItemEntity> list = new ArrayList<>();
        for (ItemDto i : items) {
            if (i instanceof PhoneDto) {
                list.add(phoneMapper.toEntity((PhoneDto) i));
            } else if (i instanceof ClothDto) {
                list.add(clothMapper.toEntity((ClothDto) i));
            }
        }
        return list;
    }
}