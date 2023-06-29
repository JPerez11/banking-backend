package com.jperez.banking.adapters.driven.jpa.postgres.mappers;

import com.jperez.banking.adapters.driven.jpa.postgres.entities.RoleEntity;
import com.jperez.banking.domain.models.RoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleEntityMapper {

    RoleModel toModel(RoleEntity roleEntity);

}
