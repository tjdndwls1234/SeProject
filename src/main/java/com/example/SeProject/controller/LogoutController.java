package com.example.SeProject.controller;


import com.example.SeProject.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LogoutController {
    public final LogoutService logoutService;

    @Autowired
    public LogoutController(LogoutService logoutService){
        this.logoutService = logoutService;
    }
}
