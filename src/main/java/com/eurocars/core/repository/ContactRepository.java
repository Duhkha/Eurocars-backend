package com.eurocars.core.repository;

import com.eurocars.core.model.Contact;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {

    @Query(value = "{}", sort = "{creationDate: -1}")
    List<Contact> getAllContacts();


}
