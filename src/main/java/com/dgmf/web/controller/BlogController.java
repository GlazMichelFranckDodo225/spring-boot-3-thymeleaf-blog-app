package com.dgmf.web.controller;

import com.dgmf.service.PostService;
import com.dgmf.web.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    // http://localhost:8080/post/oops-concepts-in-java-with-realtime-examples
    @GetMapping("/post/{postUrl}")
    public String showPost(
            @PathVariable("postUrl") String postUrl,
            Model model
    ) {
        PostDto postDto = postService.findPostByUrl(postUrl);
        model.addAttribute("post", postDto);

        return "blog/blog_post";
    }

    // Handler Method for Blog Post Search Request
    // http://localhost:8080/page/search?query=java
    @GetMapping("/page/search")
    public String searchPosts(
            @RequestParam(value = "query") String query,
            Model model
    ) {
        List<PostDto> postDtos = postService.searchPosts(query);
        model.addAttribute("posts", postDtos);

        return "blog/view_posts";
    }
}
