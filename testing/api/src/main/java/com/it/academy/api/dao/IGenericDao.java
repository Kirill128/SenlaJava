package com.it.academy.api.dao;

import com.it.academy.entitys.AEntity;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public interface IGenericDao<T extends AEntity<Integer>> {
    Class<T> getGenericClass();

    T create(T entity);

    T get(int id);

    void update(T entity);

    void delete(T entity);

    public List<T> getAll();
}
