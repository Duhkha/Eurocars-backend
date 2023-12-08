package com.eurocars.rest.controllers;

import com.eurocars.core.model.MainPage;
import com.eurocars.core.service.MainPageService;
import com.eurocars.rest.dto.UserDTO;
import com.eurocars.rest.dto.UserRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/main-page")
@SecurityRequirement(name = "JWT Security")
public class MainPageController {

    private final MainPageService mainPageService;
    public MainPageController(MainPageService mainPageService) {
        this.mainPageService=mainPageService;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/")
    public ResponseEntity<MainPage> getMainPage() {
        MainPage mainPage = mainPageService.getMainPage();
        return ResponseEntity.ok(mainPage);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<MainPage> createMainPage() {
        List<String> sampleImageUrls = Arrays.asList("url1", "url2", "url3");
        String sampleNote = "Welcome to Euro-Cars!";



        return ResponseEntity.ok(mainPageService.createMainPage(sampleImageUrls,sampleNote));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<MainPage> editMainPage(@RequestBody MainPage updatedMainPage) {
        MainPage editedMainPage = mainPageService.updateMainPage(updatedMainPage);
        return ResponseEntity.ok(editedMainPage);
    }



}
