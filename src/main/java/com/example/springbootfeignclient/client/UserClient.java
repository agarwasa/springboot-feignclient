package com.example.springbootfeignclient.client;

import com.example.springbootfeignclient.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Feign Client Interface for User API
 * 
 * This interface defines the contract for making HTTP calls to an external REST API.
 * Feign automatically generates the implementation at runtime.
 * 
 * Key points:
 * - @FeignClient: Marks this interface as a Feign client
 * - name: Logical name for the client (used for configuration)
 * - url: Base URL of the API we're calling
 * - Methods are annotated with Spring MVC annotations (@GetMapping, @PostMapping, etc.)
 * - Return types are automatically deserialized from JSON
 */
@FeignClient(name = "userClient", url = "https://jsonplaceholder.typicode.com")
public interface UserClient {

    /**
     * Get all users
     * Maps to: GET https://jsonplaceholder.typicode.com/users
     */
    @GetMapping("/users")
    List<User> getAllUsers();

    /**
     * Get a specific user by ID
     * Maps to: GET https://jsonplaceholder.typicode.com/users/{id}
     * 
     * @param id The user ID
     * @return User object
     */
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id);
}

