package com.example.notes_service.repository;

import com.example.notes_service.model.Like;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends MongoRepository<Like, String> {
    List<Like> getAllByContentId(String contentId);
    Boolean existsByUserIdAndContentId(String userId, String contentId);
}
