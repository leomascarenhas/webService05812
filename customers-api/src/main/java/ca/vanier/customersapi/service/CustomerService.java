package ca.vanier.customersapi.service;

import java.util.List;

import ca.vanier.customersapi.entity.Customer;

public interface CustomerService {
    
    Customer save(Customer customer);

    List<Customer> findAll();

}
