package com.shubz.conduit.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/main")
public class MainController {

    @GetMapping("/")
    public String health() {

        System.out.println("hello");
        return "hello";
    }
    

}
