package com.cg.service.customer;


import com.cg.model.Customer;
import com.cg.model.dto.CustomerDTO;
import com.cg.service.IGenaralService;

import java.util.List;

public interface ICustomerService extends IGenaralService<Customer> {
    List<CustomerDTO> findAllDTO();
    CustomerDTO findCustomerDTOById(long id);

    boolean addNewCustomer(String name, String email, String phone, String address);

    boolean updateCustomer(long id, String name, String email, String phone, String address);

    boolean existsByIdAndDeletedFalse(long id);

    void suspendCustomer(long id);
    boolean existsByFullName(String name);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByPhoneAndIdIsNot(String phone, long id);

    boolean existsByEmailAndIdIsNot(String email, long id);

    List<Customer> findAllByIdIsNotAndDeletedFalse(long id);

}
