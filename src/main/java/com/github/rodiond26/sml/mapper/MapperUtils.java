package com.github.rodiond26.sml.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.github.rodiond26.AppConstants.Frontend.UI_DATE_FORMAT;

public final class MapperUtils {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(UI_DATE_FORMAT);

    private MapperUtils() {
    }

    public static LocalDate toLocalDate(String date) {
        if (date == null || date.isBlank()) {
            return null;
        }
        return LocalDate.parse(date, FORMATTER);
    }

    public static String toFormattedString(LocalDate localDate) {
        if (localDate == null) {
            return "";
        }
        return localDate.format(FORMATTER);
    }
}
