package eu.it.academy.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import eu.it.academy.api.dao.IAGenericDao;
import eu.it.academy.entities.AEntity;

public abstract class AGenericDao<T extends AEntity<Integer>> implements IAGenericDao<T> {

    private Class<T> clazz;

    public AGenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @PersistenceContext
    protected EntityManager entityManager;

    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T get(Long id) {
        return entityManager.find(getGenericClass(), id);
    }
    
    public void update(T entity) {
        entityManager.merge(entity);
        entityManager.flush();
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public Class<T> getGenericClass() {
        return this.clazz;
    }
}
