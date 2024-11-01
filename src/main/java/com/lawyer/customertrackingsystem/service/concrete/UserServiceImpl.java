package com.lawyer.customertrackingsystem.service.concrete;

import com.lawyer.customertrackingsystem.dto.UserCreateDto;
import com.lawyer.customertrackingsystem.entity.User;
import com.lawyer.customertrackingsystem.repository.UserRepository;
import com.lawyer.customertrackingsystem.service.Abstract.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public void addUser(UserCreateDto userCreateDto) {
        User user=new User();
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());
        user.setEmail(userCreateDto.getEmail());
        userRepository.save(user);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        // Fetch the user from the database
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//
//        // Create and return a UserDetails object
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword()) // Password should be already encoded
//                .authorities(Collections.emptyList()) // Replace with actual roles/authorities if needed
//                .build();
//    }
}
