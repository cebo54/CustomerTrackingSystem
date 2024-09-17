package com.lawyer.customertrackingsystem.controller;

import com.lawyer.customertrackingsystem.dto.LoginDto;
import com.lawyer.customertrackingsystem.entity.User;
import com.lawyer.customertrackingsystem.security.JwtService;
import com.lawyer.customertrackingsystem.service.Abstract.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    @GetMapping
    public String showLoginPage(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "login";  // Show login page
    }

    @PostMapping
    public String login(@ModelAttribute LoginDto loginDto, Model model) {
        try {
            // Authenticate user
            User authenticatedUser = authenticationService.authenticate(loginDto);

            // Generate JWT token
            String jwtToken = jwtService.generateToken(authenticatedUser);

            // Store token in model (in real-world apps, store token in cookies/session headers)
            model.addAttribute("token", jwtToken);

            // Redirect to customer list page after successful login
            return "redirect:/customer/allCustomers";

        } catch (RuntimeException e) {
            // Handle login failure
            model.addAttribute("loginError", "Invalid username or password.");
            return "login";
        }
    }
}
