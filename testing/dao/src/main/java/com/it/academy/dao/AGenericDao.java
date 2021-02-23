package com.it.academy.dao;

import com.it.academy.api.dao.IGenericDao;
import com.it.academy.entitys.AEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AGenericDao <T extends AEntity<Integer>> implements IGenericDao<T> {
    private Class<T> clazz;

    @PersistenceContext
    protected EntityManager entityManager;

    public AGenericDao(Class<T> clazz){
        this.clazz=clazz;
    }

    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T get(int id) {
        return entityManager.find(getGenericClass(), id);
    }

    public void update(T entity) {
        entityManager.merge(entity);
        entityManager.flush();
    }

    public List<T> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getGenericClass());
        Root<T> root = query.from(getGenericClass());
        query.select(root);
        TypedQuery<T> result = entityManager.createQuery(query);
        return result.getResultList();
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public Class<T> getGenericClass() {
        return this.clazz;
    }
}
