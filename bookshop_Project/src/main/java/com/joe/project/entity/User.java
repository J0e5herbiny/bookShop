package com.joe.project.entity;

import lombok.Getter;
import lombok.Setter;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "is_admin")
    private boolean isAdmin;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String firstName, String lastName, boolean isAdmin, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
        this.email = email;
        this.password = password;
    }

}
