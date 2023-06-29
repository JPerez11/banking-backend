package com.jperez.banking.adapters.driving.http.mappers;

import com.jperez.banking.adapters.driving.http.dto.response.UserResponseDto;
import com.jperez.banking.domain.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {

    @Mapping(target = "role", source = "role.name")
    UserResponseDto toResponse(UserModel userModel);
    List<UserResponseDto> toResponseList(List<UserModel> userModelList);

}
