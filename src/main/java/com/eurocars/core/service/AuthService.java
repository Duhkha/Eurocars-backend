package com.eurocars.core.service;

import com.eurocars.core.model.User;
import com.eurocars.core.model.enums.UserType;
import com.eurocars.core.repository.UserRepository;
import com.eurocars.exceptions.repository.ResourceNotFoundException;
import com.eurocars.rest.dto.LoginDTO;
import com.eurocars.rest.dto.LoginRequestDTO;
import com.eurocars.rest.dto.UserDTO;
import com.eurocars.rest.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final UserGarageService userGarageService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, UserGarageService userGarageService) {
        this.userRepository = userRepository;
        this.userGarageService = userGarageService;
    }
    public UserDTO signUp(UserRequestDTO userRequestDTO) {

        userRequestDTO.setUserType(UserType.CUSTOMER);

        userRequestDTO.setPassword(
                passwordEncoder.encode(userRequestDTO.getPassword())
        );
        User user = userRepository.save(userRequestDTO.toEntity());

        // Create a garage for the user
        userGarageService.createUserGarage(user.getId());

        return new UserDTO(user);
    }

    public LoginDTO signIn(LoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword())
        );
        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("This user does not exist."));
        String jwt = jwtService.generateToken(user);
        String userType = user.getUserType().name();
        return new LoginDTO(jwt, userType);
    }


}