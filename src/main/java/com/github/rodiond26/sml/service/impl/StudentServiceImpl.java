package com.github.rodiond26.sml.service.impl;

import com.github.rodiond26.sml.dto.StudentDto;
import com.github.rodiond26.sml.entity.Student;
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

    private final StudentRepository repository;

    @Override
    public List<StudentDto> findAll() {
        return toDtos(repository.findAll());
    }

    @Override
    public StudentDto findById(Long id) {
        return toDto(repository.findById(id));
    }

    @Transactional
    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = repository.save(toEntity(studentDto));
        return toDto(student);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
