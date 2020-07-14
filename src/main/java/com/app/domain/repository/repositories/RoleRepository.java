package com.app.domain.repository.repositories;

import com.app.domain.model.Role;
import com.app.domain.repository.GenericRepository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends GenericRepository<Role,Long> {
    List<Role> findAllByName(Set<String> names);


}
