package com.travactory.recruitment.junior.service;

import com.travactory.recruitment.junior.model.Customer;
import com.travactory.recruitment.junior.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {

    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<Customer> getAllCustomers() {
        return this.customersRepository.findAll();
    }

    public Customer getCustomerById(Integer id) {
        return this.customersRepository.findOne(id);
    }
}
