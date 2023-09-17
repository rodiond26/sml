package com.github.rodiond26.sml.service;

import com.github.rodiond26.sml.dto.GradeDto;

import java.util.List;

public interface GradeService {

    List<GradeDto> findAll();

    GradeDto findById(Long id);

    GradeDto save(GradeDto gradeDto);

    void deleteById(Long id);
}
