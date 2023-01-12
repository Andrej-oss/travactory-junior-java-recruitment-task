package com.travactory.recruitment.junior.controller;

import com.travactory.recruitment.junior.model.Customer;
import com.travactory.recruitment.junior.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    private final CustomersService customersService;

    @Autowired
    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        List<Customer> customers = this.customersService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable(name = "id") final Integer id) {
        final Customer customer = this.customersService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
}
