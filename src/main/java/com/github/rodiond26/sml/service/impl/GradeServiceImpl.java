package com.github.rodiond26.sml.service.impl;

import com.github.rodiond26.sml.entity.Grade;
import com.github.rodiond26.sml.repository.GradeRepository;
import com.github.rodiond26.sml.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    @Override
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade findById(Long id) {
        return gradeRepository.findById(id);
    }

    @Transactional
    @Override
    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        gradeRepository.deleteById(id);
    }
}
