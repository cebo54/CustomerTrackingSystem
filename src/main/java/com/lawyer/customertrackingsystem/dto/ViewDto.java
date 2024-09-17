package com.lawyer.customertrackingsystem.dto;

import com.lawyer.customertrackingsystem.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ViewDto {

    private String customerName;
    private String customerSurname;
    private String identificationNumber;
    private Long cost;
    private Long agreedFee;

    public static ViewDto convert(Customer customer){
        return ViewDto.builder()
                .customerName(customer.getCustomerName())
                .customerSurname(customer.getCustomerSurname())
                .identificationNumber(customer.getIdentificationNumber())
                .cost(customer.getCost())
                .agreedFee(customer.getAgreedFee())
                .build();
    }
}
