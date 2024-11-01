package com.lawyer.customertrackingsystem.service.concrete;

import com.lawyer.customertrackingsystem.dto.LoginDto;
import com.lawyer.customertrackingsystem.entity.User;
import com.lawyer.customertrackingsystem.repository.UserRepository;
import com.lawyer.customertrackingsystem.service.Abstract.AuthenticationService;
import lombok.RequiredArgsConstructor;

import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;



    @Override
    public User authenticate(LoginDto loginDto) {
        try {
            // Fetch the user from the database after successful authentication
            return userRepository.findByUsername(loginDto.getUsername())
                    .orElseThrow(() -> new AuthenticationException("User not found"));

        } catch (AuthenticationException e) {
            // Handle authentication failure
            throw new RuntimeException("Invalid username or password", e);
        }
    }
}
