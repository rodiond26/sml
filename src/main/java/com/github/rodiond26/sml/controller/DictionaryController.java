package com.github.rodiond26.sml.controller;

import com.github.rodiond26.sml.dto.AppRestResponse;
import com.github.rodiond26.sml.entity.Grade;
import com.github.rodiond26.sml.service.GradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Справочники")
@RestController
@RequestMapping(value = "/api/v1/dictionaries")
@RequiredArgsConstructor
public class DictionaryController {

    private final GradeService gradeService;

    @Operation(
            summary = "Получить справочник оценок",
            description = "Получить справочник оценок"
    )
    @GetMapping("/grades")
    public AppRestResponse<List<Grade>> getAllGrades() {
        return AppRestResponse.success(gradeService.findAll());
    }

    @Operation(
            summary = "Получить оценку",
            description = "Получение оценки по идентификатору"
    )
    @GetMapping("/grades/{gradeId}")
    public AppRestResponse<Grade> getGrade(@PathVariable Long gradeId) {
        return AppRestResponse.success(gradeService.findById(gradeId));
    }

    @Operation(
            summary = "Добавить оценку",
            description = "Добавить оценку в справочник"
    )
    @PostMapping("/grades")
    public AppRestResponse<Grade> addGrade(@RequestBody Grade grade) {
        grade.setId(null);
        return AppRestResponse.success(gradeService.save(grade));
    }

    @Operation(
            summary = "Обновить оценку",
            description = "Обновить оценку по идентификатору"
    )
    @PutMapping("/grades")
    public AppRestResponse<Grade> updateGrade(@RequestBody Grade grade) {
        return AppRestResponse.success(gradeService.save(grade));
    }

    @Operation(
            summary = "Удалить оценку",
            description = "Удалить оценку по идентификатору"
    )
    @DeleteMapping("/grades/{gradeId}")
    public AppRestResponse<Grade> deleteGrade(@PathVariable Long gradeId) {
        gradeService.deleteById(gradeId);
        return AppRestResponse.emptySuccess();
    }
}
