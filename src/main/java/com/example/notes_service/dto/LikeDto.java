package com.example.notes_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class LikeDto {
    private String likeId;
    private String contentId;
    private String userId;
    private Date createdAt;
}
