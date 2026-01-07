package com.example.springbootfeignclient.controller;

import com.example.springbootfeignclient.model.User;
import com.example.springbootfeignclient.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller that exposes endpoints using the UserService
 * 
 * This controller demonstrates how to use Feign clients through the service layer
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor injection of UserService
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get all users
     * GET /api/users
     * 
     * @return List of all users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Get a specific user by ID
     * GET /api/users/{id}
     * 
     * @param id The user ID
     * @return User object
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Search users by name
     * GET /api/users/search?name={name}
     * 
     * @param name The name to search for
     * @return List of matching users
     */
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsersByName(@RequestParam String name) {
        List<User> users = userService.findUsersByName(name);
        return ResponseEntity.ok(users);
    }
}

