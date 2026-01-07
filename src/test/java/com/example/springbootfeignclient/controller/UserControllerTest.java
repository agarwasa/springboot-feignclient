package com.example.springbootfeignclient.controller;

import com.example.springbootfeignclient.model.User;
import com.example.springbootfeignclient.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for UserController
 * 
 * These tests mock the UserService to test the controller layer in isolation
 */
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    private UserController userController;

    private User user1;
    private User user2;
    private List<User> allUsers;

    @BeforeEach
    void setUp() {
        // Manually create controller instance to avoid Java 25 Mockito issues
        userController = new UserController(userService);
        
        user1 = new User();
        user1.setId(1L);
        user1.setName("Leanne Graham");
        user1.setUsername("Bret");
        user1.setEmail("Sincere@april.biz");

        user2 = new User();
        user2.setId(2L);
        user2.setName("Ervin Howell");
        user2.setUsername("Antonette");
        user2.setEmail("Shanna@melissa.tv");

        allUsers = Arrays.asList(user1, user2);
    }

    @Test
    void testGetAllUsers_Success() {
        // Given
        when(userService.getAllUsers()).thenReturn(allUsers);

        // When
        ResponseEntity<List<User>> response = userController.getAllUsers();

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<User> body = response.getBody();
        assertNotNull(body);
        assertEquals(2, body.size());
        assertEquals("Leanne Graham", body.get(0).getName());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById_Success() {
        // Given
        Long userId = 1L;
        when(userService.getUserById(userId)).thenReturn(user1);

        // When
        ResponseEntity<User> response = userController.getUserById(userId);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        User body = response.getBody();
        assertNotNull(body);
        assertEquals(userId, body.getId());
        assertEquals("Leanne Graham", body.getName());
        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void testGetUserById_NotFound() {
        // Given
        Long userId = 999L;
        when(userService.getUserById(userId)).thenReturn(null);

        // When
        ResponseEntity<User> response = userController.getUserById(userId);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void testSearchUsersByName_Success() {
        // Given
        String searchName = "Leanne";
        List<User> searchResults = Arrays.asList(user1);
        when(userService.findUsersByName(searchName)).thenReturn(searchResults);

        // When
        ResponseEntity<List<User>> response = userController.searchUsersByName(searchName);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<User> body = response.getBody();
        assertNotNull(body);
        assertEquals(1, body.size());
        assertEquals("Leanne Graham", body.get(0).getName());
        verify(userService, times(1)).findUsersByName(searchName);
    }

    @Test
    void testSearchUsersByName_NoResults() {
        // Given
        String searchName = "NonExistent";
        List<User> emptyResults = List.of();
        when(userService.findUsersByName(searchName)).thenReturn(emptyResults);

        // When
        ResponseEntity<List<User>> response = userController.searchUsersByName(searchName);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<User> body = response.getBody();
        assertNotNull(body);
        assertTrue(body.isEmpty());
        verify(userService, times(1)).findUsersByName(searchName);
    }
}

