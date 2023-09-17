package com.github.rodiond26.sml.repository.impl;

import com.github.rodiond26.sml.entity.Grade;
import com.github.rodiond26.sml.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GradeRepositoryImpl implements GradeRepository {

    private final EntityManager entityManager;

    @Override
    public List<Grade> findAll() {
        TypedQuery<Grade> query = entityManager.createQuery("from Grade", Grade.class);
        List<Grade> grades = query.getResultList();
        return grades;
    }

    @Override
    public Grade findById(Long id) {
        Grade grade = entityManager.find(Grade.class, id);
        return grade;
    }

    @Override
    public Grade save(Grade grade) {
        Grade updatedGrade = entityManager.merge(grade);
        return updatedGrade;
    }

    @Override
    public void deleteById(Long id) {
        Grade grade = entityManager.find(Grade.class, id);
        entityManager.remove(grade);
    }
}
