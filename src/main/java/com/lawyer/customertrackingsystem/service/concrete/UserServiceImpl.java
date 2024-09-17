package com.lawyer.customertrackingsystem.service.concrete;

import com.lawyer.customertrackingsystem.dto.UserCreateDto;
import com.lawyer.customertrackingsystem.entity.User;
import com.lawyer.customertrackingsystem.repository.UserRepository;
import com.lawyer.customertrackingsystem.service.Abstract.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addUser(UserCreateDto userCreateDto) {
        User user=new User();
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        user.setEmail(userCreateDto.getEmail());
        userRepository.save(user);
    }
}
