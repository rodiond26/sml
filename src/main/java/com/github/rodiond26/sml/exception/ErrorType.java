package com.github.rodiond26.sml.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    APP_ERROR("application error");

    private final String value;
}
