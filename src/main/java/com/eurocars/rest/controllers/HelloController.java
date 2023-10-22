package com.eurocars.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public  String sayHello(@RequestParam(value="name", defaultValue = "world") String name){
        return "Hey "+name+".";
    }

}
