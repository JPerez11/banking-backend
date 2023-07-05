package com.jperez.banking.adapters.driving.http.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OperationAccountRequestDto {

    private String operationType;
    private double money;

}
