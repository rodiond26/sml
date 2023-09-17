package com.github.rodiond26.sml.service;

import com.github.rodiond26.sml.entity.Grade;

import java.util.List;

public interface GradeService {

    List<Grade> findAll();

    Grade findById(Long id);

    Grade save(Grade grade);

    void deleteById(Long id);
}
