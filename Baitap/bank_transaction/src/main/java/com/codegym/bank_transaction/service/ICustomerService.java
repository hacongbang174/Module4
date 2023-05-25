package com.codegym.bank_transaction.service;


import com.codegym.bank_transaction.model.Customer;

import java.util.List;

public interface ICustomerService extends IGenaralService<Customer> {


    boolean addNewCustomer(String name, String email, String phone, String address);

    boolean updateCustomer(long id, String name, String email, String phone, String address);

    boolean existsByIdAndDeletedFalse(long id);

    void suspendCustomer(long id);

}
