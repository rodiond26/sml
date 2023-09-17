package com.github.rodiond26.sml.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.rodiond26.sml.exception.AppRestError;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Schema(description = "Базовая структура ответа")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class AppRestResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("status")
    private Boolean success = false;
    @JsonProperty("body")
    private T body;
    @JsonProperty("error")
    private AppRestError error = null;

    public static <T> AppRestResponse<T> success(final T body) {
        final AppRestResponse<T> response = new AppRestResponse<>();
        response.success = true;
        response.body = body;
        response.error = null;
        return response;
    }

    public static <T> AppRestResponse<T> emptySuccess() {
        final AppRestResponse<T> response = new AppRestResponse<>();
        response.success = true;
        response.body = null;
        response.error = null;
        return response;
    }

    public static <T> AppRestResponse<T> fail(final AppRestError error) {
        final AppRestResponse<T> response = new AppRestResponse<>();
        response.success = false;
        response.body = null;
        response.error = error;
        return response;
    }
}
