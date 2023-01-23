package ca.vanier.customersapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.vanier.customersapi.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
}
