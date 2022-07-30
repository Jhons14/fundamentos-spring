package com.fundamentos.spring.fundamentos.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;


@ConstructorBinding
@ConfigurationProperties(prefix = "user")
@Getter //Estas 3 anotaciones pertenecientes a la dependencia de lombok ahorran declarar setters, getters y el construtor
@Setter
@ToString
@AllArgsConstructor
public class UserPojo {
    private String email;
    private String password;
    private int age;

}
