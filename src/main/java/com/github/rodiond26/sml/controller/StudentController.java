package com.github.rodiond26.sml.controller;

import com.github.rodiond26.sml.dto.AppRestResponse;
import com.github.rodiond26.sml.dto.StudentDto;
import com.github.rodiond26.sml.service.StudentService;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@Tag(name = "Студенты")
@OpenAPIDefinition(
        info = @Info(
                title = "Тестовое задание",
                description = "Тестовое задание",
                version = "1.0.0-SNAPSHOT"
        )
)
@RestController
@RequestMapping(value = "/api/v1/students")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;

    @Operation(
            summary = "Получить всех студентов",
            description = "Получить всех студентов"
    )
    @GetMapping("")
    public AppRestResponse<List<StudentDto>> getAllStudents() {
        return AppRestResponse.success(studentService.findAll());
    }

    @Operation(
            summary = "Получить студента",
            description = "Получить студента по идентификатору"
    )
    @GetMapping("/{studentId}")
    public AppRestResponse<StudentDto> getStudent(@PathVariable @Min(0) Long studentId) {
        return AppRestResponse.success(studentService.findById(studentId));
    }

    @Operation(
            summary = "Добавить студента",
            description = "Добавить студента"
    )
    @PostMapping("")
    public AppRestResponse<StudentDto> addStudent(@RequestBody @NotNull StudentDto studentDto) {
        studentDto.setId(null);
        return AppRestResponse.success(studentService.save(studentDto));
    }

    @Operation(
            summary = "Обновить студента",
            description = "Обновить студента по идентификатору"
    )
    @PutMapping("")
    public AppRestResponse<StudentDto> updateStudent(@RequestBody @NotNull StudentDto studentDto) {
        return AppRestResponse.success(studentService.save(studentDto));
    }

    @Operation(
            summary = "Удалить студента",
            description = "Удалить студента по идентификатору"
    )
    @DeleteMapping("/{studentId}")
    public AppRestResponse<StudentDto> deleteStudent(@PathVariable @Min(0) Long studentId) {
        studentService.deleteById(studentId);
        return AppRestResponse.emptySuccess();
    }
}
