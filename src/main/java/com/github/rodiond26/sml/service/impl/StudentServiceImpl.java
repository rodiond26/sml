package com.github.rodiond26.sml.service.impl;

import com.github.rodiond26.sml.dto.StudentDto;
import com.github.rodiond26.sml.entity.Grade;
import com.github.rodiond26.sml.entity.Student;
import com.github.rodiond26.sml.repository.GradeRepository;
import com.github.rodiond26.sml.repository.StudentRepository;
import com.github.rodiond26.sml.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.github.rodiond26.sml.mapper.StudentMapper.*;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    @Override
    public List<StudentDto> findAll() {
        return toDtos(studentRepository.findAll());
    }

    @Override
    public StudentDto findById(Long id) {
        return toDto(studentRepository.findById(id));
    }

    @Transactional
    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = studentRepository.save(toEntity(studentDto));
        return toDto(student);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    @Override
    public StudentDto save(Long studentId, Long gradeId) {
        Student student = studentRepository.findById(studentId);
        Grade grade = gradeRepository.findById(gradeId);
        student.setGrade(grade);
        Student updatedStudent = studentRepository.save(student);
        return toDto(updatedStudent);
    }
}
