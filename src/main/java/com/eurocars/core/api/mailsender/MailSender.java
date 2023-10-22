package com.eurocars.core.api.mailsender;

import com.eurocars.core.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MailSender {
    public String send(List<User> users, String message);
}
