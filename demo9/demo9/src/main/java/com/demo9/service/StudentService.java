package com.demo9.service;

import com.demo9.model.Student;
import com.demo9.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {


    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getOne(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public Optional<Student> findOne(Long id) {
        return studentRepository.findById(id);
    }


    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student delete(Student student) {
        studentRepository.delete(student);
        return student;
    }

    @Override
    public List<Student> findAllByEmailLike(String email) {
        return studentRepository.findAllByEmailLike(email);
    }

    @Override
    public List<Student> findAllByFullNameLikeOrEmailLikeOrPhoneLikeOrAddressLike(String keySearch) {
        return studentRepository.findAllByFullNameLikeOrEmailLikeOrPhoneLikeOrAddressLike(keySearch, keySearch, keySearch, keySearch);
    }
}
