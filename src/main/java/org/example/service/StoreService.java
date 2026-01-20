package org.example.service;

import org.example.dto.ItemDto;
import org.example.dto.OrderDto;
import org.example.entity.*;
import org.example.repository.CustomerRepository;
import org.example.repository.StoreRepository;
import org.example.utils.ClothMapper;
import org.example.utils.CustomerMapper;
import org.example.utils.OrderMapper;
import org.example.utils.PhoneMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    private final PhoneMapper phoneMapper;
    private final ClothMapper clothMapper;
    private final OrderMapper orderMapper;

    public StoreService(StoreRepository storeRepository,
                        CustomerRepository customerRepository,
                        CustomerMapper customerMapper,
                        PhoneMapper phoneMapper,
                        ClothMapper clothMapper, OrderMapper orderMapper) {
        this.storeRepository = storeRepository;
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.phoneMapper = phoneMapper;
        this.clothMapper = clothMapper;
        this.orderMapper = orderMapper;
    }

    public OrderDto createOrder(Integer customerId, List<Integer> itemIds, double discount, double shipping) {
        CustomerEntity customerEntity = customerRepository.findCustomerById(customerId);
        if (customerEntity == null) {
            throw new RuntimeException("Customer not found");
        }

        List<ItemEntity> itemEntities = new ArrayList<>();
        for (Integer id : itemIds) {
            ItemEntity item = storeRepository.findItemById(id);
            if (item != null) itemEntities.add(item);
        }


        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomer(customerEntity);
        orderEntity.setItems(itemEntities);
        orderEntity.setDiscount(discount);
        orderEntity.setShippingCost(shipping);


        double itemsTotal = itemEntities.stream().mapToDouble(ItemEntity::getPrice).sum();
        double finalTotal = itemsTotal - (itemsTotal * discount / 100) + shipping;
        orderEntity.setTotalAmount(finalTotal);

        storeRepository.saveOrder(orderEntity);

        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderEntity.getId());
        orderDto.setCustomerDto(customerMapper.toDto(customerEntity));
        orderDto.setTotalAmount(orderEntity.getTotalAmount());
        orderDto.setDiscount(discount);
        orderDto.setShippingCost(shipping);

        List<ItemDto> itemDtos = new ArrayList<>();
        for (ItemEntity entity : itemEntities) {
            if (entity instanceof PhoneEntity) {
                itemDtos.add(phoneMapper.toDto((PhoneEntity) entity));
            } else if (entity instanceof ClothEntity) {
                itemDtos.add(clothMapper.toDto((ClothEntity) entity));
            }
        }
        orderDto.setItems(itemDtos);

        return orderDto;
    }

    public List<OrderDto> findAllOrders(){
        return storeRepository.findAllOrders().stream()
                .map(orderMapper::toDto)
                .toList();
    }

    public OrderDto findOrderById(Integer id) {
        return orderMapper.toDto(storeRepository.findOrderById(id));
    }


}