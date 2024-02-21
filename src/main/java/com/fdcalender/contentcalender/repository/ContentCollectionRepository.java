package com.fdcalender.contentcalender.repository;

import com.fdcalender.contentcalender.model.Content;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();

    }
    public void save(Content content) {
        contentList.add(content);
    }

    @PostConstruct
    private void init() {
        contentList.add(new Content(1, "First Content", "This is the first content", Content.Status.IDEA, Content.Type.ARTICLE, LocalDateTime.now(), null, ""));
        contentList.add(new Content(2, "Second Content", "This is the second content", Content.Status.IDEA, Content.Type.ARTICLE, LocalDateTime.now(), null, ""));
        contentList.add(new Content(3, "Third Content", "This is the third content", Content.Status.IDEA, Content.Type.ARTICLE, LocalDateTime.now(), null, ""));

    }


}
