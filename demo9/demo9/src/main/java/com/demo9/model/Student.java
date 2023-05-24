package com.demo9.model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.persistence.*;
import org.springframework.validation.*;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String fullName;
    @NotNull
    private String date;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private String address;
    @NotNull
    private String classroom;

    public Student() {
    }

    public Student(Long id, String fullName, Date date, String email, String phone, String address, String classroom) {
        this.id = id;
        this.fullName = fullName;
        this.date = String.valueOf(date);
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.classroom = classroom;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = String.valueOf(date);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", date=" + date +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}
