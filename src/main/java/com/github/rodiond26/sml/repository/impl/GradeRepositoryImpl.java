package com.github.rodiond26.sml.repository.impl;

import com.github.rodiond26.sml.entity.Grade;
import com.github.rodiond26.sml.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GradeRepositoryImpl implements GradeRepository {

    private final EntityManager entityManager;

    @Override
    public List<Grade> findAll() {
        return entityManager
                .createQuery("from Grade", Grade.class)
                .getResultList();
    }

    @Override
    public Grade findById(Long id) {
        return entityManager.find(Grade.class, id);
    }

    @Override
    public Grade save(Grade grade) {
        return entityManager.merge(grade);
    }

    @Override
    public void deleteById(Long id) {
        Grade grade = entityManager.find(Grade.class, id);
        entityManager.remove(grade);
    }
}
