package com.codegym.bank_transaction.service;

import com.codegym.bank_transaction.model.Customer;
import com.codegym.bank_transaction.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean addNewCustomer(String name, String email, String phone, String address) {
        return false;
    }

    @Override
    public boolean updateCustomer(long id, String name, String email, String phone, String address) {
        return false;
    }

    @Override
    public boolean existsByIdAndDeletedFalse(long id) {
        return false;
    }

    @Override
    public void suspendCustomer(long id) {

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customerRepository.findCustomerById(id));
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.suspendCustomer(id);
    }
}