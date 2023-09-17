package com.github.rodiond26.sml.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Студент")
public class StudentDto {
    @Schema(description = "Идентификатор", example = "13")
    private Long id;
    @Schema(description = "ФИО", example = "Сидоров Сидор Сидорович")
    @NotNull
    @NotBlank
    private String fullName;
    @Schema(description = "Дата рождения", example = "2001.02.03")
    @NotNull
    @NotBlank
    private String birthDate;
    @Schema(description = "Успеваемость студента", example = "хор")
    private String gradeText;
}
