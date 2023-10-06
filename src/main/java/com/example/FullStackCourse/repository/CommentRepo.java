package com.example.FullStackCourse.repository;

import com.example.FullStackCourse.Entity.Comment;
import com.example.FullStackCourse.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {

    List<Comment> findAllByPost(Post post);
    Comment findByIdAndUserId(Long commentId,Long userId);
}
