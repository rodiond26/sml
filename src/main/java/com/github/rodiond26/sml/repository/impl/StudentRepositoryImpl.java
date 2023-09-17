package com.github.rodiond26.sml.repository.impl;

import com.github.rodiond26.sml.entity.Student;
import com.github.rodiond26.sml.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {
    private final EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        return entityManager
                .createQuery("from Student", Student.class)
                .getResultList();
    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public void deleteById(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
