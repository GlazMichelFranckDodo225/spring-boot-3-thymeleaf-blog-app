package com.dgmf.mapper;

import com.dgmf.entity.Post;
import com.dgmf.web.dto.PostDto;

public class PostMapper {
    // Map Post Entity to PostDto
    public static PostDto mapToPostDto(Post post) {
        PostDto postDto = PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .content(post.getContent())
                .url(post.getUrl())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .build();

        return postDto;
    }

    // Map PostDto to Post Entity
    public static Post mapToPost(PostDto postDto) {
        Post post = Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .description(postDto.getDescription())
                .content(postDto.getContent())
                .url(postDto.getUrl())
                .createdOn(postDto.getCreatedOn())
                .updatedOn(postDto.getUpdatedOn())
                .build();

        return post;
    }
}
