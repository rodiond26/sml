package com.github.rodiond26.sml.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Schema(description = "Успеваемость студента")
public class GradeDto {

    @Schema(description = "Идентификатор оценки", example = "3")
    private Long id;
    @Schema(description = "Текст оценки", example = "хор")
    @NotNull
    @NotBlank
    private String text;
    @Schema(description = "Минимальное значение", example = "4.0")
    @Min(0)
    @Max(100)
    private Double minValue;
    @Schema(description = "Максимальное значение", example = "4.99")
    @Min(0)
    @Max(100)
    private Double maxValue;
}
