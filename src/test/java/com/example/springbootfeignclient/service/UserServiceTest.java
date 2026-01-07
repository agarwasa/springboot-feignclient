package com.example.springbootfeignclient.service;

import com.example.springbootfeignclient.client.UserClient;
import com.example.springbootfeignclient.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for UserService
 * 
 * These tests mock the UserClient to test the service layer in isolation
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserClient userClient;

    @InjectMocks
    private UserService userService;

    private User user1;
    private User user2;
    private User user3;
    private List<User> allUsers;

    @BeforeEach
    void setUp() {
        // Create test users
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

        user3 = new User();
        user3.setId(3L);
        user3.setName("Clementine Bauch");
        user3.setUsername("Samantha");
        user3.setEmail("Nathan@yesenia.net");

        allUsers = Arrays.asList(user1, user2, user3);
    }

    @Test
    void testGetAllUsers_Success() {
        // Given
        when(userClient.getAllUsers()).thenReturn(allUsers);

        // When
        List<User> result = userService.getAllUsers();

        // Then
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Leanne Graham", result.get(0).getName());
        verify(userClient, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById_Success() {
        // Given
        Long userId = 1L;
        when(userClient.getUserById(userId)).thenReturn(user1);

        // When
        User result = userService.getUserById(userId);

        // Then
        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals("Leanne Graham", result.getName());
        verify(userClient, times(1)).getUserById(userId);
    }

    @Test
    void testGetUserById_NotFound() {
        // Given
        Long userId = 999L;
        when(userClient.getUserById(userId)).thenReturn(null);

        // When
        User result = userService.getUserById(userId);

        // Then
        assertNull(result);
        verify(userClient, times(1)).getUserById(userId);
    }

    @Test
    void testFindUsersByName_ExactMatch() {
        // Given
        String searchName = "Leanne";
        when(userClient.getAllUsers()).thenReturn(allUsers);

        // When
        List<User> result = userService.findUsersByName(searchName);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Leanne Graham", result.get(0).getName());
        verify(userClient, times(1)).getAllUsers();
    }

    @Test
    void testFindUsersByName_PartialMatch() {
        // Given
        String searchName = "Graham";
        when(userClient.getAllUsers()).thenReturn(allUsers);

        // When
        List<User> result = userService.findUsersByName(searchName);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.get(0).getName().contains("Graham"));
    }

    @Test
    void testFindUsersByName_CaseInsensitive() {
        // Given
        String searchName = "LEANNE";
        when(userClient.getAllUsers()).thenReturn(allUsers);

        // When
        List<User> result = userService.findUsersByName(searchName);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Leanne Graham", result.get(0).getName());
    }

    @Test
    void testFindUsersByName_NoMatch() {
        // Given
        String searchName = "NonExistent";
        when(userClient.getAllUsers()).thenReturn(allUsers);

        // When
        List<User> result = userService.findUsersByName(searchName);

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindUsersByName_NullName() {
        // Given
        String searchName = null;
        when(userClient.getAllUsers()).thenReturn(allUsers);

        // When
        List<User> result = userService.findUsersByName(searchName);

        // Then
        assertNotNull(result);
        // Should return all users when name is null
        assertEquals(3, result.size());
        verify(userClient, times(1)).getAllUsers();
    }

    @Test
    void testFindUsersByName_EmptyString() {
        // Given
        String searchName = "";
        when(userClient.getAllUsers()).thenReturn(allUsers);

        // When
        List<User> result = userService.findUsersByName(searchName);

        // Then
        assertNotNull(result);
        // Should return all users when name is empty
        assertEquals(3, result.size());
        verify(userClient, times(1)).getAllUsers();
    }
}

