package com.codewitharjun.fullstackbackend.repository;

import com.codewitharjun.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// this interface connects User entity with database
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository gives:
    // save()       -> save user obj
    // findAll()    -> get all users
    // findById()   -> get user by id
    // deleteById() -> delete user
}