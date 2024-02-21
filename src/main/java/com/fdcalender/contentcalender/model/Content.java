package com.fdcalender.contentcalender.model;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String title,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
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
        CONFERENCE_TALK
    }
}
