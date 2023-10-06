package com.example.FullStackCourse.Entity;

import com.example.FullStackCourse.Entity.Enum.ERole;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true,updatable = false)
    private String username;
    @Column(nullable = false)
    private String lastname;
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "text")
    private String bio;
    @Column(length = 3000)
    private String password;
    @ElementCollection(targetClass = ERole.class)
    @CollectionTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"))
    private Set<ERole> role =new HashSet<>();// set может содержать только уникальные элементы
   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user",orphanRemoval = true)
    private List<Post> posts =new ArrayList<>();
   @JsonFormat(pattern = "yyyy-mm-dd HH-mm-ss")
   @Column(updatable = false)
    private LocalDateTime createdDate;// время создания
    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public User() {
    }

    @PrePersist // задает значение атрибута дл создания новой записи в БД
    protected void onCreate(){
        this.createdDate = LocalDateTime.now();
    }

}
