package com.dgmf.web.controller;

import com.dgmf.entity.Post;
import com.dgmf.service.PostService;
import com.dgmf.web.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private PostService postService;

    // Create "GET Request" Handler Method and
    // Return Model and View
    // Endpoint : http://localhost:8080/admin/post
    @GetMapping("/admin/post")
    public String post(Model model) {
        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);

        return "/admin/post";
    }
}
