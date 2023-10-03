package com.banu.utility;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class MyFactoryRepository<T,ID> implements ICrud<T, ID>{
    private Session session;
    private Transaction transaction;

    EntityManager entityManager;
    CriteriaBuilder criteriaBuilder ;

    T t;
    public MyFactoryRepository(T entity){
        this.entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
        this.t = entity;
    }

    private void openSession(){
        session = HibernateUtility.getSessionFactory().openSession();
        transaction = session.beginTransaction();

    }
    private void closeSession(){
        transaction.commit();
        session.close();
    }

    @Override
    public T save(T entity) {
        openSession();
        session.save(entity);
        closeSession();
        return entity;
    }

    @Override
    public void update(T entity) {
        openSession();
        session.update(entity);
        closeSession();
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public Optional<T> findById(ID id) {
        CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"),id));
        T result = entityManager.createQuery(criteria).getSingleResult();
        return Optional.ofNullable(result);
    }

    @Override
    public void saveAll(Iterable<T> entites) {
        openSession();
        entites.forEach(e->{
            session.save(e);
        });
        closeSession();
    }

    @Override
    public void delete(T entity) {
        openSession();
        session.delete(entity);
        closeSession();
    }

    @Override
    public void deleteById(ID id) {
        CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"),id));
        T result = entityManager.createQuery(criteria).getSingleResult();
        openSession();
        session.delete(result);
        closeSession();
    }

    @Override
    public boolean existById(ID id) {
        CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"),id));
        T entity = entityManager.createQuery(criteria).getSingleResult();
        if(entity!=null){
            return true;
        }
        return false;
    }

    @Override
    public List<T> findByColumnNameAndValue(String columnName, String value) {
        CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get(columnName),value));
        return entityManager.createQuery(criteria).getResultList();
    }
}
