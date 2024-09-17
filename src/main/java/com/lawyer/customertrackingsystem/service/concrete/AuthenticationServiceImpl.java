package com.lawyer.customertrackingsystem.service.concrete;

import com.lawyer.customertrackingsystem.dto.LoginDto;
import com.lawyer.customertrackingsystem.entity.User;
import com.lawyer.customertrackingsystem.repository.UserRepository;
import com.lawyer.customertrackingsystem.service.Abstract.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;


    private final AuthenticationManager authenticationManager;

    @Override
    public User authenticate(LoginDto loginDto) {
        try {
            // Authenticate the user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(),
                            loginDto.getPassword()
                    )
            );

            // Fetch the user from the database after successful authentication
            return userRepository.findByUsername(loginDto.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        } catch (AuthenticationException e) {
            // Handle authentication failure
            throw new RuntimeException("Invalid username or password", e);
        }
    }
}
