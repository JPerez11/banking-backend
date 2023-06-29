package com.jperez.banking.adapters.driving.http.mappers;

import com.jperez.banking.adapters.driving.http.dto.request.UserRequestDto;
import com.jperez.banking.domain.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {

    @Mapping(target = "role.name", source = "role")
    UserModel toModel(UserRequestDto userRequest);

}
