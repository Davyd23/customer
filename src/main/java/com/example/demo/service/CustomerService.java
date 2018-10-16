package com.example.demo.service;

import com.example.demo.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    public CustomerDto save(CustomerDto customer);
    public List<CustomerDto> findAll();
}
