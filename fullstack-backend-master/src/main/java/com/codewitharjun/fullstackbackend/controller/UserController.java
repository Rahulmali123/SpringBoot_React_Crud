package com.codewitharjun.fullstackbackend.controller;

import com.codewitharjun.fullstackbackend.exception.UserNotFoundException;
import com.codewitharjun.fullstackbackend.model.User;
import com.codewitharjun.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // this is REST API controller
@CrossOrigin("http://localhost:3000") // allow React frontend
@RequestMapping("/users") // base URL (clean API design)
public class UserController {

    @Autowired
    private UserRepository userRepository; // DB object

    // CREATE user
    @PostMapping
    User newUser(@RequestBody User newUser) {
        // newUser = object coming from React
        return userRepository.save(newUser); // save obj
    }

    // GET all users
    @GetMapping
    List<User> getAllUsers() {
        return userRepository.findAll(); // return list
    }

    // GET user by id
    @GetMapping("/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // UPDATE user
    @PutMapping("/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {

        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername()); // update username
                    user.setName(newUser.getName());         // update name
                    user.setEmail(newUser.getEmail());       // update email
                    return userRepository.save(user);        // save updated obj
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // DELETE user
    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable Long id) {

        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id); // error if not found
        }

        userRepository.deleteById(id); // delete from DB

        return "User with id " + id + " deleted successfully";
    }
}