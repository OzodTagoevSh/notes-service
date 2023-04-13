package com.example.notes_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto {
    private String contentId;

    @NotBlank(message = "Note should not be empty!")
    @Size(min = 5, message = "Note should contain at least 5 characters!")
    private String note;
    private Date createdDate;
}
