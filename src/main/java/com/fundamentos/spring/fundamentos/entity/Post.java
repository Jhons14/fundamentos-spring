package com.fundamentos.spring.fundamentos.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Getter
@Setter
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(length = 200)
    private String description;

    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(Long id, String description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }
}
