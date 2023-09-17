package com.github.rodiond26.sml.controller;

import com.github.rodiond26.sml.dto.AppRestResponse;
import com.github.rodiond26.sml.dto.StudentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Студенты")
@RestController
@RequestMapping(value = "/api/v1/students")
public class StudentController {

    @Operation(
            summary = "Получение студента",
            description = "Получение студента по идентификатору"
    )
    @GetMapping("/{studentId}")
    public AppRestResponse<StudentDto> getStudent() {
        return null;
    }
}
