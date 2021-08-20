package com.peaksoft.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainController {



    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("/main-page")
    public  String mainController(){
        return "main-page";
    }
}
