package com.app.infrastructure.repository.jpa;

import com.app.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface JpaRoleRepository extends JpaRepository<Role,Long> {
    List<Role> findAllByNameIn(Set<String> names);

}
