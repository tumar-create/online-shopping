package org.example.controller;


import org.example.dto.CustomerDto;
import org.example.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping()
    public List<CustomerDto> getAllCustomers() {
        return service.findAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping("/registration")
    public CustomerDto saveCustomer(@RequestBody CustomerDto customer) {
        return service.saveCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) {
        service.deleteCustomer(id);
    }
}