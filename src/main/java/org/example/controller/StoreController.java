package org.example.controller;


import org.example.dto.OrderDto;
import org.example.dto.OrderRequest;
import org.example.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/order")
    public OrderDto createOrder(@RequestBody OrderRequest request) {
        return storeService.createOrder(
                request.getCustomerId(),
                request.getItemIds(),
                request.getDiscount(),
                request.getShippingCost()
        );
    }

    @GetMapping("/order")
    public List<OrderDto> findAllOrders() {
        return storeService.findAllOrders();
    }

    @GetMapping("/order/{id}")
    public OrderDto findOrderById(@PathVariable("id") Integer id) {
        return storeService.findOrderById(id);
    }
}