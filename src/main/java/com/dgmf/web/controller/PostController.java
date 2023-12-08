package com.dgmf.web.controller;

import com.dgmf.service.PostService;
import com.dgmf.web.dto.PostDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/posts")
// @RequiredArgsConstructor
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Handler Method to Handle "GET All Posts" Request and
    // Return Model and View
    // Endpoint : http://localhost:8080/admin/posts
    // Create a Post - Step 5
    @GetMapping
    public String posts(Model model) {
        List<PostDto> postDtos = postService.findAllPosts();
        model.addAttribute("posts", postDtos);

        System.out.println("Trace : PostController : post() Method");
        System.out.println("List of Post : \n" + postDtos);

        return "/admin/posts";
    }

    // Handler Method to Handle "New Post" Request and
    // Return Model and View
    // Endpoint : http://localhost:8080/admin/posts/newpost
    // Create a Post - Step 1
    @GetMapping("/newpost")
    public String newPostForm(Model model) {
        PostDto postDto = new PostDto();
        model.addAttribute("post", postDto);

        return "/admin/create_post"; // Create a Post - Step 2
    }

    // Handler Method to Handle "Submit Form" Request
    // and Return Model and View
    // Create a Post - Step 3
    @PostMapping
    public String createPost(
            @Valid @ModelAttribute("post") PostDto postDto,
            BindingResult result,
            Model model) {
        // Using "BindingResult" to Check the Errors and Return to the UI
        if(result.hasErrors()) {
            // If there is any Error in Form Submission, we
            // return the same Post
            model.addAttribute("post", postDto);

            return "/admin/create_post";
        }

        // Create the Blog Post Url with the Title
        postDto.setUrl(createPostUrl(postDto.getTitle()));

        postService.createPost(postDto);

        // Once a User Submits the Form
        // Create a Post - Step 4
        return "redirect:/admin/posts";
    }

    // Handler Method to Handle Edit Post Request
    @GetMapping("/{postId}/edit")
    public String editPostForm(
            @PathVariable("postId") Long postId,
            Model model
    ) {
        // Retrieved the Post by Id
        PostDto postDto = postService.findPostById(postId);
        // Add the Post to Model
        model.addAttribute("post", postDto);

        // Return the Dedicated View
        return "admin/edit_post";
    }

    private static String createPostUrl(String postTitle) {
        // Create the Blog Post Url
        // To Lower Case the Blog Post Title
        String title = postTitle.trim().toLowerCase();
        // Replace all Spaces with "-"
        String url = title.replaceAll("\\s+", "-");
        // Replace all Symbols with "-"
        url = url.replaceAll("[^A-Za-z0-9]", "-");

        return url;
    }

}
