package com.dgmf.web.controller;

import com.dgmf.service.PostService;
import com.dgmf.web.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogController {
    private final PostService postService;

    // Handler Method for Root Request
    // Example: http://localhost:8080/
    @GetMapping("/")
    public String viewBlogPosts(Model model) {
        List<PostDto> allPostDtos = postService.findAllPosts();
        model.addAttribute("allPosts", allPostDtos);

        return "blog/view_posts";
    }

    // Handler Method for View Post Request
    // Example: http://localhost:8080/post/
    @GetMapping("/post/{postUrl}")
    public String showPost(
            @PathVariable("postUrl") String postUrl,
            Model model
    ) {
        PostDto postDto = postService.findPostByUrl(postUrl);
        model.addAttribute("post", postDto);

        return "blog/blog_post";
    }
}
