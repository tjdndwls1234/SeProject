package com.example.planmate.controller;


import com.example.planmate.service.LogoutService;
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
