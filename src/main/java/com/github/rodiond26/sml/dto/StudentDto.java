package com.github.rodiond26.sml.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Студент")
public class StudentDto {
    @Schema(description = "Идентификатор студента", example = "13")
    private Long id;
    @Schema(description = "ФИО студента", example = "Сидоров Сидор Сидорович")
    private String fullName;
    @JsonIgnore
    private Long gradeId;
    @Schema(description = "Успеваемость студента", example = "хор")
    private String gradeText;
}
