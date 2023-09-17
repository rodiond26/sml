package com.github.rodiond26.sml.service;

import com.github.rodiond26.sml.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    Student save(Student student);

    void deleteById(Long id);
}
