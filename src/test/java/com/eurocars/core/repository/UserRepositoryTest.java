package com.eurocars.core.repository;

import com.eurocars.core.model.User;
import com.eurocars.core.model.enums.UserType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindAllCustomUsers() {
        List<User> users = userRepository.findAllCustom();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    public void shouldFindByEmailCustom() {
        String testEmail = "idk@gmail.com";
        Optional<User> user = userRepository.findByEmailCustom(testEmail);
        assertTrue(user.isPresent());
        assertEquals(testEmail, user.get().getEmail());
    }

    @Test
    public void shouldFindByEmail() {
        String testEmail = "idk@gmail.com";
        Optional<User> user = userRepository.findByEmail(testEmail);
        assertTrue(user.isPresent());
        assertEquals(testEmail, user.get().getEmail());
    }

    @Test
    public void shouldFindByUsernameOrEmail() {
        String testUsernameOrEmail = "idk@gmail.com";
        Optional<User> user = userRepository.findByUsernameOrEmail(testUsernameOrEmail);
        assertTrue(user.isPresent());
        assertTrue(testUsernameOrEmail.equals(user.get().getEmail()) || testUsernameOrEmail.equals(user.get().getUsername()));
    }

    @Test
    public void shouldFindFirstByEmailLike() {
        String emailPattern = "test%";
        Optional<User> user = userRepository.findFirstByEmailLike(emailPattern);
        assertTrue(user.isPresent());
        assertTrue(user.get().getEmail().contains(emailPattern.replace("%", "")));
    }

    @Test
    public void shouldFindByEmailAndUserTypeOrderByCreationDateDesc() {
        String testEmail = "idk@gmail.com";
        UserType userType = UserType.ADMIN;
        List<User> users = userRepository.findByEmailAndUserTypeOrderByCreationDateDesc(testEmail, userType);
        assertNotNull(users);
        for (User user : users) {
            assertEquals(testEmail, user.getEmail());
            assertEquals(userType, user.getUserType());
        }
    }
}
