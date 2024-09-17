package com.lawyer.customertrackingsystem.controller;

import com.lawyer.customertrackingsystem.dto.CreateDto;
import com.lawyer.customertrackingsystem.dto.UpdateDto;
import com.lawyer.customertrackingsystem.dto.ViewDto;
import com.lawyer.customertrackingsystem.entity.Customer;
import com.lawyer.customertrackingsystem.service.Abstract.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody CreateDto createDto) {
        customerService.addUser(createDto);
        return ResponseEntity.ok("Customer created successfully");
    }

    @PostMapping("/deleteCustomer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }

    @GetMapping("/allCustomers")
    public String getAllCustomers(Model model) {
        List<ViewDto> customers = customerService.getUsers();
        model.addAttribute("customers", customers);
        return "customers";  // Thymeleaf template for customers list
    }

    @PutMapping("/updateCosts/{id}")
    public String updateCosts(@PathVariable("id") int id, @ModelAttribute UpdateDto updateDto) {
        customerService.updateCosts(id, updateDto);
        return "redirect:/customer/allCustomers";
    }

    @GetMapping("/update/{id}")
    public String showUpdatePage(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.findById(id);
        UpdateDto updateDto = new UpdateDto(customer.getCost(), customer.getAgreedFee());
        model.addAttribute("updateDto", updateDto);
        model.addAttribute("customer", customer);
        return "updateCustomer";
    }
}
