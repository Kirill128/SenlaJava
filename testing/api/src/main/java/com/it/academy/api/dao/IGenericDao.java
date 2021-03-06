package com.it.academy.api.dao;

import com.it.academy.entitys.AEntity;

import java.util.List;

public interface IGenericDao<T extends AEntity<Integer>> {
    Class<T> getGenericClass();

    T create(T entity);

    T get(int id);

    void update(T entity);

    void delete(T entity);

    public List<T> getAll();
}
