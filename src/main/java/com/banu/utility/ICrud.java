package com.banu.utility;

import java.util.List;
import java.util.Optional;

public interface ICrud <T,ID>{

    // saveAll, delete, deleteById, existById, findByEntity, findByColumnNameAndValue

    T save(T entity);

    void update(T entity);

    List<T> findAll();

    Optional<T> findById(ID id);

    void saveAll(Iterable<T> entites);

    void delete(T entity);
    void deleteById(ID id);
    boolean existById(ID id);
    List<T> findByColumnNameAndValue(String columnName,String value);
}
