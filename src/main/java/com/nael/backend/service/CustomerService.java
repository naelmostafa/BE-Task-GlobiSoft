package com.nael.backend.service;

import com.nael.backend.entity.Customer;
import com.nael.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.findById(customer.getId()).map(c -> {
            c.setName(customer.getName());
            c.setNumber(customer.getNumber());
            return customerRepository.save(c);
        }).orElseGet(() -> customerRepository.save(customer));

    }


}
