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
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    private void init() {
        contentList.add(new Content(1, "https://www.baeldung.com", "Baeldung", "Learning", Content.Status.PUBLISHED, Content.Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now()));
        contentList.add(new Content(2, "https://www.baeldung.com", "Baeldung", "Learning", Content.Status.PUBLISHED, Content.Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now()));
        contentList.add(new Content(3, "https://www.baeldung.com", "Baeldung", "Learning", Content.Status.PUBLISHED, Content.Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now()));
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }
    
    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
