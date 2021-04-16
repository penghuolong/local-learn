package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/oauth1")
    @PreAuthorize(value = "hasRole('role-1')")
    public String testOAuth1(){
        return "role-1:success!";
    }
    @GetMapping("/oauth2")
    @PreAuthorize(value = "hasRole('role-2')")
    public String testOAuth2(){
        return "role-2:success!";
    }
}
