package com.lawyer.customertrackingsystem.service.Abstract;

import com.lawyer.customertrackingsystem.dto.CreateDto;
import com.lawyer.customertrackingsystem.dto.UpdateDto;
import com.lawyer.customertrackingsystem.dto.ViewDto;
import com.lawyer.customertrackingsystem.entity.Customer;

import java.util.List;

public interface CustomerService {
    void addUser(CreateDto createDto);

    void deleteCustomer(int id);

    List<ViewDto> getUsers();

    void updateCosts(int id,UpdateDto updateDto);

    Customer findById(int id);
}
