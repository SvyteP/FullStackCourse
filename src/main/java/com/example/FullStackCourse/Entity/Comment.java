package com.example.FullStackCourse.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private Long userId;
    @Column(columnDefinition = "text",nullable = false)
    private String massage;
    @Column(updatable = false)
    private LocalDateTime createdDate;// время создания
    @PrePersist // задает значение атрибута дл создания новой записи в БД
    protected void onCreate(){
        this.createdDate = LocalDateTime.now();
    }

}

