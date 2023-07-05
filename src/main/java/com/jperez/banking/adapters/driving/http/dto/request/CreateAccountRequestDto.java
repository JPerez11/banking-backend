package com.jperez.banking.adapters.driving.http.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateAccountRequestDto {

    private String accountType;
    private double balance;

}
