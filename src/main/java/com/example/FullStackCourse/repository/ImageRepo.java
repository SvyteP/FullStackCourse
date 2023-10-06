package com.example.FullStackCourse.repository;

import com.example.FullStackCourse.Entity.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepo extends JpaRepository<ImageModel,Long> {

    Optional<ImageModel> findByUserId(Long id);
    Optional<ImageModel> findByPostId(Long id);
}
