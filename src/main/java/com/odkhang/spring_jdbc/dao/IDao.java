package com.odkhang.spring_jdbc.dao;

import java.util.Collection;
import java.util.Optional;

public interface IDao<T> {

    Optional<T> get(int id);

    Optional<T> getByName(String name);

    Collection<T> getAll();

    int save(T t);

    void update(T t);

    void delete(T t);
}
