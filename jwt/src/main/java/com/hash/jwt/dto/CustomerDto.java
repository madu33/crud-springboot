package com.hash.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Integer mobile;
    private String userName;
    private String password;
}
