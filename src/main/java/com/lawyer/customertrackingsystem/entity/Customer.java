package com.lawyer.customertrackingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Customer Name")
    private String customerName;

    @Column(name = "Customer Surname")
    private String customerSurname;

    @Column(name = "Identification Number",length = 11)
    private String identificationNumber;

    @Column(name = "Cost")
    private Long cost;

    @Column(name = "Agreed Fee")
    private Long agreedFee;

}
