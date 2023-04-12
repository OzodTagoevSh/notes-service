package com.example.notes_service.controller;

import com.example.notes_service.dto.ContentDto;
import com.example.notes_service.exception.ResourceNotFound;
import com.example.notes_service.service.ContentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contents")
public class ContentController {
    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping
    public ResponseEntity<List<ContentDto>> getAllContents() {
        return new ResponseEntity<>(contentService.getAllNotesFromNewToOld(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContentDto> createContent(@RequestBody @Valid ContentDto contentDto) {
        return new ResponseEntity<>(contentService.createContent(contentDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContent(@PathVariable(name = "id") String contentId) throws ResourceNotFound {
        contentService.deleteContent(contentId);
        return new ResponseEntity<>("Content deleted successfully!", HttpStatus.OK);
    }
}
