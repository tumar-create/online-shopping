package org.example.service;


import org.example.dto.CustomerDto;
import org.example.entity.CustomerEntity;
import org.example.repository.CustomerRepository;
import org.example.utils.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto saveCustomer(CustomerDto customerDto) {
        CustomerEntity entity = customerMapper.toEntity(customerDto);

        customerRepository.saveCustomer(entity);

        return customerMapper.toDto(entity);
    }

    public CustomerDto findById(Integer id) {
        return customerMapper.toDto(customerRepository.findCustomerById(id));
    }

    public List<CustomerDto> findAllCustomers() {
        return customerRepository.findAllCustomers().stream()
                .map(customerMapper::toDto)
                .toList();
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteCustomer(id);
    }
}