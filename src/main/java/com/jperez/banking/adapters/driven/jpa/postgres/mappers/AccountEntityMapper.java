package com.jperez.banking.adapters.driven.jpa.postgres.mappers;

import com.jperez.banking.adapters.driven.jpa.postgres.entities.AccountEntity;
import com.jperez.banking.domain.models.AccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AccountEntityMapper {

    @Mapping(target = "user", source = "user")
    AccountEntity toEntity(AccountModel bank);

    @Mapping(target = "user", source = "user")
    AccountModel toModel(AccountEntity bank);

}
