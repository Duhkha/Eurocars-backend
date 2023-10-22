package com.eurocars.core.repository;


import com.eurocars.core.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository(){
        this.users= Arrays.asList(
                new User("1", "John", "Lennon", "john.lennon@email.com", "123-456-7890", "Inquiry", "I'm interested in your cars."),
                new User("2", "Paul", "McCartney", "paul.mccartney@email.com", "987-654-3210", "Appointment", "I'd like to schedule a test drive."),
                new User("3", "George", "Harrison", "george.harrison@email.com", "555-123-4567", "Question", "Can you provide more information about the BMW M3?"),
                new User("4", "Ringo", "Starr", "ringo.starr@email.com", "111-222-3333", "Inquiry", "I'm looking for a car in my budget.")
        );
    }

    public List<User> findAll(){
        return users;
    }


}

