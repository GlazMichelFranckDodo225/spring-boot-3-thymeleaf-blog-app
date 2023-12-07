package com.dgmf.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PostDto {
    private Long id;
    @NotEmpty(message = "Post Title should not be Empty")
    private String title;
    private String url;
    @NotEmpty(message = "Post Content should not be Empty")
    private String content;
    @NotEmpty(message = "Post Description should not be Empty")
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
