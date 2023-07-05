package com.jperez.banking.adapters.driving.http.mappers;

import com.jperez.banking.adapters.driving.http.dto.response.AccountResponseDto;
import com.jperez.banking.domain.models.AccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountResponseMapper {

    @Mapping(target = "openingDate", expression = "java(accountModel.getOpeningDate().format(java.time.format" +
            ".DateTimeFormatter.ofPattern(\"yyyy-MM-dd HH:mm:ss\")))")
    @Mapping(target = "userName", source = "user.name")
    @Mapping(target = "userEmail", source = "user.email")
    AccountResponseDto toResponse(AccountModel accountModel);

}
