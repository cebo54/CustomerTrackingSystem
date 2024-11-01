package com.lawyer.customertrackingsystem.controller;

import com.lawyer.customertrackingsystem.dto.LoginDto;
import com.lawyer.customertrackingsystem.entity.User;
import com.lawyer.customertrackingsystem.service.Abstract.AuthenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationService authenticationService;


    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "login";  // Show login page
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto, Model model, HttpServletResponse response) {
        try {

            return "redirect:/customer/allCustomers";  // Redirect on success
        } catch (RuntimeException e) {
            model.addAttribute("loginError", "Invalid username or password.");
            return "login";  // Stay on the login page on failure
        }
    }

}
