package com.fundamentos.spring.fundamentos.repository;

import com.fundamentos.spring.fundamentos.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long> {
}
