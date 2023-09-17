package com.github.rodiond26.sml.controller;

import com.github.rodiond26.sml.dto.AppRestResponse;
import com.github.rodiond26.sml.entity.Student;
import com.github.rodiond26.sml.service.StudentService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
public class StudentController {

    private final StudentService studentService;

    @Operation(
            summary = "Получить всех студентов",
            description = "Получить всех студентов"
    )
    @GetMapping("")
    public AppRestResponse<List<Student>> getAllStudents() {
        return AppRestResponse.success(studentService.findAll());
    }

    @Operation(
            summary = "Получить студента",
            description = "Получить студента по идентификатору"
    )
    @GetMapping("/{studentId}")
    public AppRestResponse<Student> getStudent(@PathVariable Long studentId) {
        return AppRestResponse.success(studentService.findById(studentId));
    }

    @Operation(
            summary = "Добавить студента",
            description = "Добавить студента"
    )
    @PostMapping("")
    public AppRestResponse<Student> addStudent(@RequestBody Student student) {
        student.setId(null);
        return AppRestResponse.success(studentService.save(student));
    }

    @Operation(
            summary = "Обновить студента",
            description = "Обновить студента по идентификатору"
    )
    @PutMapping("")
    public AppRestResponse<Student> updateStudent(@RequestBody Student student) {
        return AppRestResponse.success(studentService.save(student));
    }

    @Operation(
            summary = "Удалить студента",
            description = "Удалить студента по идентификатору"
    )
    @DeleteMapping("/{studentId}")
    public AppRestResponse<Student> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteById(studentId);
        return AppRestResponse.emptySuccess();
    }
}
