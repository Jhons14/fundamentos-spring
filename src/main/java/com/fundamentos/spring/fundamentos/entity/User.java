package com.fundamentos.spring.fundamentos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 40)
    private String email;

    @Column
    private LocalDate birthdate;

    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Post> posts= new ArrayList<>();

    public User() {
    }

    public User(String name, String email, LocalDate birthdate) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
    }
}
