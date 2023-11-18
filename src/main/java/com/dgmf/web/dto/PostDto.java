package com.dgmf.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PostDto {
    private Long id;
    private String title;
    private String url;
    private String content;
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
