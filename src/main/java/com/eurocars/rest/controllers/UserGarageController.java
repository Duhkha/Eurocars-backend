package com.eurocars.rest.controllers;

import com.eurocars.core.model.User;
import com.eurocars.core.model.UserGarage;
import com.eurocars.core.service.UserGarageService;
import com.eurocars.core.service.UserService;
import com.eurocars.exceptions.repository.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/myGarage")
@SecurityRequirement(name = "JWT Security")
public class UserGarageController {

    private final UserGarageService userGarageService;
    private final UserService userService;

    public UserGarageController(UserGarageService userGarageService,UserService userService) {
        this.userGarageService = userGarageService;
        this.userService=userService;
    }

    private User getUserOrThrow() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        return userService.filterByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<UserGarage> getUserGarage() {
        User user = getUserOrThrow();
        String userId = user.getId();
        UserGarage userGarage = userGarageService.getUserGarage(userId);
        return ResponseEntity.ok(userGarage);


    }

    @RequestMapping(method = RequestMethod.POST, path = "/add-car/{carId}")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<UserGarage> addCarToGarage(@PathVariable String carId){
        User user = getUserOrThrow();
        String userId = user.getId();
        userGarageService.addCarToGarage(userId, carId);
        UserGarage updatedUserGarage = userGarageService.getUserGarage(userId);
        return ResponseEntity.ok(updatedUserGarage);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/remove-car/{carId}")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<Void> removeCarFromGarage(@PathVariable String carId) {
        User user = getUserOrThrow();
        String userId = user.getId();
        userGarageService.removeCarFromGarage(userId, carId);
        return ResponseEntity.noContent().build();
    }






}
