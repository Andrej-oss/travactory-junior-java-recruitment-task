package com.travactory.recruitment.junior.repository;

import com.travactory.recruitment.junior.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customer, Integer> {
}
