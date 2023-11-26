package com.eurocars.exceptions.repository;

import com.eurocars.exceptions.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends GeneralException {
    public ResourceNotFoundException(){
        super(HttpStatus.NOT_FOUND.value());
    }

    public ResourceNotFoundException(String message){
        super(HttpStatus.NOT_FOUND.value(), message);
    }
}
