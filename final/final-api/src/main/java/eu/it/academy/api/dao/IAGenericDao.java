package eu.it.academy.api.dao;

import eu.it.academy.entities.AEntity;

public interface IAGenericDao<T extends AEntity<Integer>> {

    Class<T> getGenericClass();

    T create(T entity);

    T get(Long id);

    void update(T entity);

    void delete(T entity);
}
