package com.example.FullStackCourse.repository;

import com.example.FullStackCourse.Entity.Post;
import com.example.FullStackCourse.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends JpaRepository<Post,Long> {

    //Нахождение всех постов юзера и сортировка их по дате создания сверху вниз или снузу вверх
    //SELECT * FROM POST as p WHERE User='user' SORT DESC
    List<Post> findAllByUserOrderByCreatedDataDesc(User user);

    //Все посты для всех User
    List<Post> findAllByOrderByCreatedDateDesc();

    //Найти 1 пост по id и User
    Optional<Post> findPostByIdAndUser(Long id,User user);
}
