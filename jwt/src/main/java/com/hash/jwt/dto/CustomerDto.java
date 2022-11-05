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
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Integer number;
    private String userName;
    private String password;
}
