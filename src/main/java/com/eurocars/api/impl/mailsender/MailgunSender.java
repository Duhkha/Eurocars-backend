package com.eurocars.api.impl.mailsender;

import com.eurocars.core.api.mailsender.MailSender;
import com.eurocars.core.model.User;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;


import java.util.List;

@Component
// @ConditionalOnProperty(name = "configuration.mailsender.default", havingValue = "mailgun")
public class MailgunSender implements MailSender {

    @Override
    public String send(List<User> users, String message){
        for(User user: users){
            System.out.println("Message sent to: "+user.getEmail());
        }
        return  "Message: "+message+" ł sent via Mailgun.";
    }
}
