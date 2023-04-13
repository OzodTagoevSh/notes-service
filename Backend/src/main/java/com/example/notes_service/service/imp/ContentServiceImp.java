package com.example.notes_service.service.imp;

import com.example.notes_service.dto.ContentDto;
import com.example.notes_service.exception.ResourceNotFound;
import com.example.notes_service.model.Content;
import com.example.notes_service.repository.ContentRepository;
import com.example.notes_service.service.ContentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImp implements ContentService {
    private final ContentRepository contentRepository;
    private final ModelMapper modelMapper;

    public ContentServiceImp(ContentRepository contentRepository, ModelMapper modelMapper) {
        this.contentRepository = contentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ContentDto> getAllNotesFromNewToOld() {
        List<Content> contents = contentRepository.findAllByOrderByCreatedDateDesc();
        return contents.stream()
                .map(content -> modelMapper.map(content, ContentDto.class))
                .toList();
    }

    @Override
    public ContentDto createContent(ContentDto contentDto) {
        Content content = new Content();
        content.setCreatedDate(new Date());
        content.setNote(contentDto.getNote());
        contentRepository.save(content);
        return modelMapper.map(content, ContentDto.class);
    }

    @Override
    public void deleteContent(String contentId) throws ResourceNotFound {
        Content content = contentRepository.findById(contentId).orElseThrow(() -> new ResourceNotFound("Content", "Id", contentId));
        contentRepository.delete(content);
    }
}
