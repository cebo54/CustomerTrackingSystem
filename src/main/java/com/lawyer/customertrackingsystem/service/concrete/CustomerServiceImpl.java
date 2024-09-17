package com.lawyer.customertrackingsystem.service.concrete;

import com.lawyer.customertrackingsystem.dto.CreateDto;
import com.lawyer.customertrackingsystem.dto.UpdateDto;
import com.lawyer.customertrackingsystem.dto.ViewDto;
import com.lawyer.customertrackingsystem.entity.Customer;
import com.lawyer.customertrackingsystem.repository.CustomerRepository;
import com.lawyer.customertrackingsystem.service.Abstract.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public void addUser(CreateDto createDto) {
        Customer customer=new Customer();
        customer.setCustomerName(createDto.getCustomerName());
        customer.setCustomerSurname(createDto.getCustomerSurname());
        customer.setIdentificationNumber(createDto.getIdentificationNumber());
        customer.setCost(createDto.getCost());
        customer.setAgreedFee(createDto.getAgreedFee());
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer=customerRepository.findById(id).orElseThrow();
        customerRepository.deleteById(id);
    }

    @Override
    public List<ViewDto> getUsers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(ViewDto::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void updateCosts(int id,UpdateDto updateDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();

            // Update only if the field is not null
            if (updateDto.getCost() != null) {
                customer.setCost(updateDto.getCost());
            }

            if (updateDto.getAgreedFee() != null) {
                customer.setAgreedFee(updateDto.getAgreedFee());
            }

            customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }

    }

    @Override
    public Customer findById(int id) {
        Customer customer=customerRepository.findById(id).orElseThrow();
        return customer;
    }
}
