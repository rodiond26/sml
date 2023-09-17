package com.github.rodiond26.sml.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GradeDto {
    @Schema(description = "Идентификатор оценки", example = "3")
    private Long id;
    @Schema(description = "Текст оценки", example = "хор")
    private String text;
    @Schema(description = "Минимальное значение", example = "4.0")
    private Double minValue;
    @Schema(description = "Максимальное значение", example = "4.99")
    private Double maxValue;
}
