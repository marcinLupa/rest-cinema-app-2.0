package com.app.domain.repository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T,ID> {
    Optional<T> findOneById(ID id);
    List<T> findAll();
    Optional<T> save(T t);
    ID deleteById(ID id);
}
