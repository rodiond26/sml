package com.github.rodiond26.sml.service;

import com.github.rodiond26.sml.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAll();

    StudentDto findById(Long id);

    StudentDto save(StudentDto student);

    void deleteById(Long id);

    StudentDto save(Long studentId, Long gradeId);
}
