package com.udays.personal.projects.spring.boot.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping(method = RequestMethod.GET, value = "/api/greet")
    public String sayHello(){
        return "Hello";
    }

}
