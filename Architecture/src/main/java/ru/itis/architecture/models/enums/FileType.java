package ru.itis.architecture.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FileType {
    TXT("txt"),
    PNG("png"),
    ANOTHER("another");

    @Getter
    private final String value;
}
