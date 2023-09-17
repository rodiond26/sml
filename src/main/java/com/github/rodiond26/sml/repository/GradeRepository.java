package com.github.rodiond26.sml.repository;

import com.github.rodiond26.sml.entity.Grade;

import java.util.List;

public interface GradeRepository {
    List<Grade> findAll();

    Grade findById(Long id);

    Grade save(Grade grade);

    void deleteById(Long id);
}
