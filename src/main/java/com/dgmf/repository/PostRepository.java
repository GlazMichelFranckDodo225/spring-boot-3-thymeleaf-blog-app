package com.dgmf.repository;

import com.dgmf.entity.Post;
import com.dgmf.web.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostByUrl(String postUrl);
    @Query("SELECT p from Post p WHERE " +
            " p.title LIKE CONCAT('%', :query, '%') OR " +
            " p.description LIKE CONCAT('%', :query, '%')")
    List<Post> searchPosts(String query);
}
