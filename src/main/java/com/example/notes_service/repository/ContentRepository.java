package com.example.notes_service.repository;

import com.example.notes_service.model.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends MongoRepository<Content, String> {
    List<Content> findAllByOrderByCreatedDateDesc();
}
