package com.dgmf.web.controller;

import com.dgmf.service.PostService;
import com.dgmf.web.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
// @RequiredArgsConstructor
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Create "GET All Posts Request" Handler Method and
    // Return Model and View
    // Endpoint : http://localhost:8080/admin/posts
    @GetMapping("/admin/posts")
    public String posts(Model model) {
        List<PostDto> postDtos = postService.findAllPosts();
        model.addAttribute("posts", postDtos);

        System.out.println("Trace : PostController : post() Method");
        System.out.println("List of Post : \n" + postDtos);

        return "/admin/posts";
    }
}
