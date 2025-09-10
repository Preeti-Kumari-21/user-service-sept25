package com.scaler.userservicesept25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel{

    private String name;

    private String email;

    private String password;

    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Role> roles;
}
