package com.dgmf.service.impl;

import com.dgmf.entity.Post;
import com.dgmf.mapper.PostMapper;
import com.dgmf.repository.PostRepository;
import com.dgmf.service.PostService;
import com.dgmf.web.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
// @RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        System.out.println("Trace : PostServiceImpl : postRepository.findAll() Method");
        System.out.println("List of Post : \n" + posts);

        List<PostDto> postDtos = posts.stream()
                .map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());

        System.out.println("Trace : PostServiceImpl : findAllPosts() Method");
        System.out.println("List of Post : \n" + postDtos);

        return postDtos;
    }

    @Override
    public void createPost(PostDto postDto) {
        Post post = PostMapper.mapToPost(postDto);

        postRepository.save(post);
    }

    @Override
    public PostDto findPostById(Long postId) {
        Post post = postRepository.findById(postId).get();
        PostDto postDto = PostMapper.mapToPostDto(post);

        return postDto;
    }

    @Override
    public void updatePost(PostDto postDto) {
        Post post = PostMapper.mapToPost(postDto);

        postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
       postRepository.deleteById(postId);
    }

    @Override
    public PostDto findPostByUrl(String postUrl) {
        Post post = postRepository.findPostByUrl(postUrl);
        PostDto postDto = PostMapper.mapToPostDto(post);

        return postDto;
    }

    @Override
    public List<PostDto> searchPosts(String query) {
        List<Post> posts = postRepository.searchPosts(query);
        List<PostDto> postDtos = posts.stream()
                .map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());

        return postDtos;
    }
}
