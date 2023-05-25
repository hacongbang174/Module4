package com.codegym.bank_transaction.service;

import java.util.List;
import java.util.Optional;

public interface IGenaralService <T>{
    List<T> findAll();

    Optional<T> findById(Long id);


    void save(T t);

    void remove(Long id);
}
