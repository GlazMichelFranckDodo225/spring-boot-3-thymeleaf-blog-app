package com.dgmf.service.impl;

import com.dgmf.entity.Post;
import com.dgmf.mapper.PostMapper;
import com.dgmf.repository.PostRepository;
import com.dgmf.service.PostService;
import com.dgmf.web.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream()
                .map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());

        return postDtos;
    }
}
