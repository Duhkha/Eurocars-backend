package com.eurocars.core.service;

import com.eurocars.core.api.mailsender.MailSender;
import com.eurocars.core.model.User;
import com.eurocars.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public String sendEmailToAllUsers(String message){
        List<User> users = userRepository.findAll();
        return mailgunSender.send(users,message);
        // return sendgridSender.send(users, message);


        // Method 2: The appropriate implementation is decided based on configuration
        // return mailSender.send(users, message);
    }



}