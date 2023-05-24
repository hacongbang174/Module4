package com.demo9.service;

import com.demo9.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService{
    List<Student> findAll();

    Student getOne(Long id);

    Optional<Student> findOne(Long id);

    Student save(Student student);

    Student delete(Student student);

    List<Student> findAllByEmailLike(String email);

    List<Student> findAllByFullNameLikeOrEmailLikeOrPhoneLikeOrAddressLike(String keySearch);
}
