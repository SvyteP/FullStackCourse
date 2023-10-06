package com.example.FullStackCourse.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String caption;
    private String location;
    private Integer likes;

    @Column
    @ElementCollection(targetClass = String.class)
    private Set<String> likeUser =new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private  User user;
    @OneToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER,mappedBy = "post",orphanRemoval = true)
    private List<Comment> comments =new ArrayList<>();
    @Column(updatable = false)
    private LocalDateTime createdDate;
    @PrePersist//выполняется до создания
    protected void onCreate(){
        this.createdDate = LocalDateTime.now();
    }

}
