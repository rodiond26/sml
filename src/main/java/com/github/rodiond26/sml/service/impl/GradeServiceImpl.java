package com.github.rodiond26.sml.service.impl;

import com.github.rodiond26.sml.dto.GradeDto;
import com.github.rodiond26.sml.entity.Grade;
import com.github.rodiond26.sml.repository.GradeRepository;
import com.github.rodiond26.sml.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.github.rodiond26.sml.mapper.GradeMapper.*;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository repository;

    @Override
    public List<GradeDto> findAll() {
        return toDtos(repository.findAll());
    }

    @Override
    public GradeDto findById(Long id) {
        return toDto(repository.findById(id));
    }

    @Transactional
    @Override
    public GradeDto save(GradeDto gradeDto) {
        Grade grade = repository.save(toEntity(gradeDto));
        return toDto(grade);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
