package com.eurocars.core.service;

import com.eurocars.core.api.mailsender.MailSender;
import com.eurocars.exceptions.repository.ResourceNotFoundException;
import com.eurocars.core.model.User;
import com.eurocars.core.repository.UserRepository;
import com.eurocars.rest.dto.UserDTO;
import com.eurocars.rest.dto.UserRequestDTO;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




import java.io.NotActiveException;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;


@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    private MailSender mailgunSender;

    @Autowired
    private MailSender sendgridSender;



    public UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();


        return users
                .stream()
                .map(UserDTO::new)
                .collect(toList());
    }

    public UserDTO getUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user with the given ID does not exist.");
        }
        return new UserDTO(user.get());
    }

    public UserDTO addUser(UserRequestDTO payload) {
        User user = userRepository.save(payload.toEntity());
        return new UserDTO(user);
    }

    public UserDTO updateUser(String id, UserRequestDTO payload) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("The user with the given ID does not exist.");
        }
        User updatedUser = payload.toEntity();
        updatedUser.setId(user.get().getId());
        updatedUser = userRepository.save(updatedUser);
        return new UserDTO(updatedUser);
    }

    public void deleteUser(String id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }

    public UserDTO filterByEmail(String email) {
        Optional<User> user = userRepository.findFirstByEmailLike(email);
        // Optional<User> user = userRepository.findByEmailCustom(email);
        return user.map(UserDTO::new).orElse(null);
    }


//username=email
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }






}