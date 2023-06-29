package com.jperez.banking.adapters.driven.jpa.postgres.mappers;

import com.jperez.banking.adapters.driven.jpa.postgres.entities.UserEntity;
import com.jperez.banking.domain.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    UserModel toModel(UserEntity userEntity);

    UserEntity toEntity(UserModel userModel);

    List<UserModel> toModelList(List<UserEntity> userEntityList);

}
