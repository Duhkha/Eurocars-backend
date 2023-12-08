package com.eurocars.rest.controllers;


import com.eurocars.core.model.Contact;
import com.eurocars.core.model.User;
import com.eurocars.core.service.ContactService;
import com.eurocars.rest.dto.ContactDTO;
import com.eurocars.rest.dto.ContactRequestDTO;
import com.eurocars.rest.dto.UserDTO;
import com.eurocars.rest.dto.UserRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@SecurityRequirement(name = "JWT Security")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Contact>> getContacts() {
        List<Contact> contacts = contactService.getContacts();
        return ResponseEntity.ok(contacts);
    }


 @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<ContactDTO> addContact(@RequestBody ContactRequestDTO contact) {
        return ResponseEntity.ok(contactService.addContact(contact));
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable String id) {
        return ResponseEntity.ok(contactService.findContactById(id));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable String id, @RequestBody ContactRequestDTO contact) {
        return ResponseEntity.ok(contactService.updateContact(id, contact));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteContact(@PathVariable String id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }










}
