package com.lawyer.customertrackingsystem.controller;

import com.lawyer.customertrackingsystem.dto.UserCreateDto;
import com.lawyer.customertrackingsystem.service.Abstract.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public String addUser(@ModelAttribute UserCreateDto userCreateDto, Model model) {
        try {
            userService.addUser(userCreateDto);  // Call service to create user
            return "redirect:/login";  // Redirect to login page after successful registration
        } catch (Exception e) {
            model.addAttribute("error", "User registration failed: " + e.getMessage());
            return "signup";  // Return to signup page in case of failure
        }
    }

    @GetMapping("/signup")
    public String showSignUpPage(Model model) {
        model.addAttribute("userCreateDto", new UserCreateDto());
        return "signup";  // This returns the signup.html page
    }
}
