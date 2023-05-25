package com.codegym.bank_transaction.repository;

import com.codegym.bank_transaction.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT NEW Customer (c.id,c.full_name,c.email,c.phone,c.address,c.balance,c.deleted) FROM Customer c WHERE c.deleted = false")
    List<Customer> findAll();

    @Query("SELECT NEW Customer (c.id,c.full_name,c.email,c.phone,c.address,c.balance,c.deleted) FROM Customer c WHERE c.id = :id")
    Customer findCustomerById(@Param("id") long id);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customers (full_name,email,phone,address) VALUES (:name, :email, :phone, :address)", nativeQuery = true)
    boolean addCustomer(@Param("name") String name,@Param("email") String email,@Param("phone") String phone,@Param("address") String address);

    @Modifying
    @Query(value = "UPDATE customers SET full_name = :name, email :email, phone :phone, address :address WHERE id = :id", nativeQuery = true)
    boolean updateCustomer(@Param("id") long id,@Param("name") String name,@Param("email") String email,@Param("phone") String phone,@Param("address") String address);

    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.deleted = TRUE WHERE c.id = :id")
    void suspendCustomer(@Param("id") long id);

    boolean existsByIdAndDeletedFalse(long id);

}
