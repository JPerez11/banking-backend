package com.jperez.banking.adapters.driving.http.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountResponseDto {

    private String accountType;
    private String accountNumber;
    private double balance;
    private String openingDate;
    private String userName;
    private String userEmail;

}
