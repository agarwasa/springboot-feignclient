package com.example.springbootfeignclient.service;

import com.example.springbootfeignclient.client.UserClient;
import com.example.springbootfeignclient.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class that uses the Feign client to interact with external API
 * 
 * This demonstrates the typical pattern:
 * - Service layer uses the Feign client
 * - Can add business logic, error handling, caching, etc.
 * - Controllers call services, not Feign clients directly
 */
@Service
public class UserService {

    private final UserClient userClient;

    /**
     * Constructor injection of Feign client
     * Spring automatically provides the Feign client implementation
     */
    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    /**
     * Get all users from the external API
     * 
     * @return List of all users
     */
    public List<User> getAllUsers() {
        return userClient.getAllUsers();
    }

    /**
     * Get a specific user by ID
     * 
     * @param id The user ID
     * @return User object, or null if not found
     */
    public User getUserById(Long id) {
        return userClient.getUserById(id);
    }

    /**
     * Example of adding business logic on top of Feign client
     * Find users by name (case-insensitive)
     * 
     * @param name The name to search for
     * @return List of matching users
     */
    public List<User> findUsersByName(String name) {
        return getAllUsers().stream()
                .filter(user -> user.getName() != null && 
                               user.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}

