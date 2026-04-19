package com.codewitharjun.fullstackbackend.model;

import javax.persistence.*; // JPA annotations

@Entity // this class is mapped to DB table
public class User {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment id
    private Long id;

    private String username; // this is username field
    private String name;     // this is name field
    private String email;    // this is email field

    public Long getId() {
        return id; // return id
    }

    public void setId(Long id) {
        this.id = id; // set id
    }

    public String getUsername() {
        return username; // return username
    }

    public void setUsername(String username) {
        this.username = username; // set username
    }

    public String getName() {
        return name; // return name
    }

    public void setName(String name) {
        this.name = name; // set name
    }

    public String getEmail() {
        return email; // return email
    }

    public void setEmail(String email) {
        this.email = email; // set email
    }
}