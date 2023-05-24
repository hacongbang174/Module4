package com.demo9.repository;

import com.demo9.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface StudentRepository  extends JpaRepository <Student, Long>  {

    List<Student> findAllByEmailLike(String email);

    List<Student> findAllByFullNameLikeOrEmailLikeOrPhoneLikeOrAddressLike(String fullName, String email, String phone, String address);


}
