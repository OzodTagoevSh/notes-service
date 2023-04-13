package com.example.notes_service.controller;

import com.example.notes_service.dto.LikeDto;
import com.example.notes_service.exception.ResourceNotFound;
import com.example.notes_service.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<LikeDto> likeNote(@RequestBody LikeDto likeDto) {
        return new ResponseEntity<>(likeService.addLike(likeDto), HttpStatus.CREATED);
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<List<LikeDto>> getLikesByContentId(@PathVariable String contentId) {
        return new ResponseEntity<>(likeService.getLikeByContentId(contentId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> dislikeNote(@PathVariable(name = "id") String likeId) throws ResourceNotFound {
        likeService.removeLike(likeId);
        return new ResponseEntity<>("You disliked this note!", HttpStatus.NO_CONTENT);
    }
}
