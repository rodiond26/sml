package com.github.rodiond26.sml.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Schema(description = "Ошибка")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
public class AppRestError implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Schema(description = "Идентификатор ошибки", example = "1111-2222-3333")
    private String uuid;
    @JsonProperty("name")
    @Schema(description = "Код ошибки", example = "APP_ERROR")
    private String name;
    @JsonProperty("message")
    @Schema(description = "Текст ошибки", example = "Текст ошибки")
    private String message;
}
