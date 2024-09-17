package com.lawyer.customertrackingsystem.dto;

import com.lawyer.customertrackingsystem.entity.Customer;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateDto {
    private String customerName;
    private String customerSurname;
    private String identificationNumber;
    private Long cost;
    private Long agreedFee;
}
