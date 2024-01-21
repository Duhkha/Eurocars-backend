package com.eurocars.core.service;

import com.eurocars.core.api.mailsender.MailSender;
import com.eurocars.core.model.User;
import com.eurocars.core.repository.UserRepository;
import com.eurocars.exceptions.repository.ResourceNotFoundException;
import com.eurocars.rest.dto.UserDTO;
import com.eurocars.rest.dto.UserRequestDTO;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    // Mock other dependencies as needed
    @MockBean
    private MailSender mailgunSender;

    @MockBean
    private MailSender sendgridSender;

    @Autowired
    private UserService userService;

    @Test
    public void shouldAddUser() {
        UserRequestDTO userRequestDTO = new UserRequestDTO(); // Populate with test data
        User user = userRequestDTO.toEntity();
        Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        UserDTO savedUser = userService.addUser(userRequestDTO);

        assertThat(savedUser).isNotNull();
        // Additional assertions as necessary
    }

    @Test
    public void shouldGetUserById() {
        String userId = "xyxyxy";
        User user = new User(); // Populate with test data
        user.setId(userId);
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        UserDTO foundUser = userService.getUserById(userId);

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getId()).isEqualTo(userId);
    }

    @Test
    public void shouldThrowExceptionWhenUserNotFound() {
        String userId = "xxxx";
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            userService.getUserById(userId);
        });
    }

    @Test
    public void shouldUpdateUser() {
        String userId = "yxyxyx";
        UserRequestDTO userRequestDTO = new UserRequestDTO(); // Populate with test data
        User user = userRequestDTO.toEntity();

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        UserDTO updatedUser = userService.updateUser(userId, userRequestDTO);

        assertThat(updatedUser).isNotNull();
    }

    @Test
    public void shouldDeleteUser() {
        String userId = "weeew";
        User user = new User();
        user.setId(userId);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        doNothing().when(userRepository).delete(user);

        userService.deleteUser(userId);

        verify(userRepository, times(1)).delete(user);
    }
}
