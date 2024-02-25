package com.fdcalender.contentcalender.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;




public record Content(
    Integer id,
    String url,
    @NotBlank
    String title,
    String desc,
    Status status,
    Type contentType,
    LocalDateTime dateCreated,
    LocalDateTime dateUpdated
) {
    public enum Status {
    IDEA,
    IN_PROGRESS,
    COMPLETED,
    PUBLISHED
}

    public enum Type {
        ARTICLE,
        VIDEO,
        COURSE,
        CONFERENCE_TALK, TYPE
    }
}
