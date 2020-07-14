package com.app.infrastructure.repository.impl;

import com.app.domain.model.Role;
import com.app.domain.repository.repositories.RoleRepository;
import com.app.infrastructure.repository.jpa.JpaRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Repository
public class RoleRepositoryImpl implements RoleRepository {
private final JpaRoleRepository jpaRoleRepository;

    @Override
    public List<Role> findAllByName(Set<String> names) {
        return jpaRoleRepository.findAllByNameIn(names);
    }

    @Override
    public Optional<Role> findOneById(Long id) {
        return jpaRoleRepository.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return jpaRoleRepository.findAll();
    }

    @Override
    public Optional<Role> save(Role role) {
        return Optional.of(jpaRoleRepository.save(role));
    }

    @Override
    public Long deleteById(Long id){
    jpaRoleRepository.deleteById(id);
        return id;
    }
}
