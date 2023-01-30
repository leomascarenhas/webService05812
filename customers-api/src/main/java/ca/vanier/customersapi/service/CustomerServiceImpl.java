package ca.vanier.customersapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.vanier.customersapi.entity.Customer;
import ca.vanier.customersapi.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        // Empty fields

        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateById(Customer customer, Long id) {
        Customer newCustomer = customerRepository.findById(id).get();

        // Validation

        newCustomer.setName(customer.getName());
        newCustomer.setEmail(customer.getEmail());
        // newCustomer.setAddress(customer.getAddress());

        return customerRepository.save(newCustomer);
    }

    // Exercise:
    // Implement Delete, Update & find methods
    
}
