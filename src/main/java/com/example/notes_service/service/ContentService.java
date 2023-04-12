package com.example.notes_service.service;

import com.example.notes_service.dto.ContentDto;
import com.example.notes_service.exception.ResourceNotFound;

import java.util.List;

public interface ContentService {
    List<ContentDto> getAllNotesFromNewToOld();
    ContentDto createContent(ContentDto contentDto);
    void deleteContent(String contentId) throws ResourceNotFound;
}
