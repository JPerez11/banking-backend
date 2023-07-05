package com.jperez.banking.adapters.driving.http.mappers;

import com.jperez.banking.adapters.driving.http.dto.request.CreateAccountRequestDto;
import com.jperez.banking.domain.models.AccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountRequestMapper {

    AccountModel toModel(CreateAccountRequestDto createAccountRequest);

}
