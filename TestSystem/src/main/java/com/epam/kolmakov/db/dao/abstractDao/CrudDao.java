package com.epam.kolmakov.db.dao.abstractDao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    Optional<T> findById(Long id);
    boolean save(T model);
    boolean update(T model);
    boolean delete(Long id);
    List<T> findAll();
}