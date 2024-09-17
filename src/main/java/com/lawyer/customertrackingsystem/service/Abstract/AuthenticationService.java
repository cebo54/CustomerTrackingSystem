package com.lawyer.customertrackingsystem.service.Abstract;

import com.lawyer.customertrackingsystem.dto.LoginDto;
import com.lawyer.customertrackingsystem.entity.User;

public interface AuthenticationService {
    User authenticate(LoginDto loginDto);
}
