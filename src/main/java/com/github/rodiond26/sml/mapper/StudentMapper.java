package com.github.rodiond26.sml.mapper;

import com.github.rodiond26.sml.dto.StudentDto;
import com.github.rodiond26.sml.entity.Grade;
import com.github.rodiond26.sml.entity.Student;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.github.rodiond26.sml.mapper.MapperUtils.toFormattedString;
import static com.github.rodiond26.sml.mapper.MapperUtils.toLocalDate;

public final class StudentMapper {
    private StudentMapper() {
    }

    public static List<StudentDto> toDtos(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return Collections.emptyList();
        }
        return students.stream()
                .map(StudentMapper::toDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static StudentDto toDto(Student student) {
        if (student == null) {
            return null;
        }
        return StudentDto.builder()
                .id(student.getId())
                .fullName(student.getFullName())
                .birthDate(toFormattedString(student.getBirthDate()))
                .gradeText(getGradeText(student.getGrade()))
                .build();
    }

    public static Student toEntity(StudentDto studentDto) {
        if (studentDto == null) {
            return null;
        }
        return Student.builder()
                .id(studentDto.getId())
                .fullName(studentDto.getFullName())
                .birthDate(toLocalDate(studentDto.getBirthDate()))
                .build();
    }

    public static String getGradeText(Grade grade) {
        return grade == null
                ? ""
                : grade.getText();
    }
}
