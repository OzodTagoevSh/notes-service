package com.example.notes_service.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "likes")
public class Like {
    @Id
    private String likeId;
    private String contentId;
    private String userId;
    private Date createdAt;
}
