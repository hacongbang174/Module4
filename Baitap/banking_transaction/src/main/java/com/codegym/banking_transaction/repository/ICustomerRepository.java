package com.codegym.banking_transaction.repository;

import java.util.List;

public interface ICustomerRepository<T>{
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
}
