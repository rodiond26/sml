package com.github.rodiond26.sml.controller;

import com.github.rodiond26.sml.dto.AppRestResponse;
import com.github.rodiond26.sml.entity.Grade;
import com.github.rodiond26.sml.service.GradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Справочники")
@RestController
@RequestMapping(value = "/api/v1/dictionaries")
@RequiredArgsConstructor
public class DictionaryController {


    @Value("${spring.sql.init.schema-locations}")
    private static String path;

    private final GradeService gradeService;

    @Operation(
            summary = "Получить оценку",
            description = "Получение оценки по идентификатору"
    )
    @GetMapping("/grades")
    public AppRestResponse<List<Grade>> getGrade1() {
        System.out.println("path = " + path);

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
            summary = "Получить оценку",
            description = "Получение оценки по идентификатору"
    )
    @PostMapping("/grades")
    public AppRestResponse<Grade> addGrade(@RequestBody Grade grade) {
        grade.setId(null);
        return AppRestResponse.success(gradeService.save(grade));
    }

    @Operation(
            summary = "Получить оценку",
            description = "Получение оценки по идентификатору"
    )
    @PutMapping("/grades")
    public AppRestResponse<Grade> updateGrade(@RequestBody Grade grade) {
        return AppRestResponse.success(gradeService.save(grade));
    }

    @Operation(
            summary = "Получить оценку",
            description = "Получение оценки по идентификатору"
    )
    @DeleteMapping("/grades/{gradeId}")
    public AppRestResponse<Grade> deleteGrade(@PathVariable Long gradeId) {
        gradeService.deleteById(gradeId);
        return AppRestResponse.emptySuccess();
    }
}
