package com.example.notes_service.service;

import com.example.notes_service.dto.LikeDto;
import com.example.notes_service.exception.ResourceNotFound;

import java.util.List;

public interface LikeService {
    LikeDto addLike(LikeDto like);
    List<LikeDto> getLikeByContentId(String contentId);
    void removeLike(String likeId) throws ResourceNotFound;
}
