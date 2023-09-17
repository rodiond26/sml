package com.github.rodiond26.sml.service.impl;

import com.github.rodiond26.sml.entity.Student;
import com.github.rodiond26.sml.repository.StudentRepository;
import com.github.rodiond26.sml.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository gradeRepository;

    @Override
    public List<Student> findAll() {
        return gradeRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return gradeRepository.findById(id);
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return gradeRepository.save(student);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        gradeRepository.deleteById(id);
    }
}
