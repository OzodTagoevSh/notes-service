package com.example.notes_service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "notes")
public class Content {
    @Id
    private String contentId;
    private String note;
    private Date createdDate;
}
