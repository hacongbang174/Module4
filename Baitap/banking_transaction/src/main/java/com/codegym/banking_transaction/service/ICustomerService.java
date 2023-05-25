package com.codegym.banking_transaction.service;

import java.util.List;

public interface ICustomerService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
}
