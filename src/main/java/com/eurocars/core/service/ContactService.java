package com.eurocars.core.service;

import com.eurocars.core.model.Contact;
import com.eurocars.core.repository.ContactRepository;
import com.eurocars.exceptions.repository.ResourceNotFoundException;
import com.eurocars.rest.dto.ContactDTO;
import com.eurocars.rest.dto.ContactRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getContacts() {
        return contactRepository.getAllContacts();
    }

    public ContactDTO findContactById(String id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isEmpty()) {
            throw new ResourceNotFoundException("The contact with the given ID does not exist.");
        }
        return new ContactDTO(contact.get());
    }

    public ContactDTO addContact(ContactRequestDTO payload) {
        Contact contact = contactRepository.save(payload.toEntity());
        return new ContactDTO(contact);
    }

    public ContactDTO updateContact(String id, ContactRequestDTO payload) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isEmpty()) {
            throw new ResourceNotFoundException("The appointment with the given ID does not exist.");
        }
        Contact updatedContact = payload.toEntity();
        updatedContact.setId(contact.get().getId());
        updatedContact = contactRepository.save(updatedContact);

        return new ContactDTO(updatedContact);
    }

    public void deleteContact(String id) {
        Optional<Contact> contact = contactRepository.findById(id);
        contact.ifPresent(contactRepository::delete);
    }
}