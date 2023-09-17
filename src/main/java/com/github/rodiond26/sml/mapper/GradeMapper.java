package com.github.rodiond26.sml.mapper;

import com.github.rodiond26.sml.dto.GradeDto;
import com.github.rodiond26.sml.entity.Grade;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class GradeMapper {
    private GradeMapper() {
    }

    public static List<GradeDto> toDtos(List<Grade> grades) {
        if (grades == null || grades.isEmpty()) {
            return Collections.emptyList();
        }
        return grades.stream()
                .map(GradeMapper::toDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static GradeDto toDto(Grade grade) {
        if (grade == null) {
            return null;
        }
        return GradeDto.builder()
                .id(grade.getId())
                .text(grade.getText())
                .minValue(grade.getMinValue())
                .maxValue(grade.getMaxValue())
                .build();
    }

    public static Grade toEntity(GradeDto gradeDto) {
        if (gradeDto == null) {
            return null;
        }
        return Grade.builder()
                .id(gradeDto.getId())
                .text(gradeDto.getText())
                .minValue(gradeDto.getMinValue())
                .maxValue(gradeDto.getMaxValue())
                .build();
    }
}
