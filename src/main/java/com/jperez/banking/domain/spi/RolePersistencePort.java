package com.jperez.banking.domain.spi;

import com.jperez.banking.domain.models.RoleModel;

public interface RolePersistencePort {

    RoleModel findRoleByName(String name);

}
