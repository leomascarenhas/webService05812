package ca.vanier.customersapi.service;

import java.util.List;
import java.util.Optional;

import ca.vanier.customersapi.entity.Customer;

public interface CustomerService {
    
    Customer save(Customer customer);

    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    void deleteById(Long id);

    Customer updateById(Customer customer, Long id);

}
