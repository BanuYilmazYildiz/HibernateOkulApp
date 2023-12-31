package com.banu.criteria;

import com.banu.repository.entity.Ogrenci;
import com.banu.utility.HibernateUtility;
import com.banu.utility.ICrud;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OgrenciCriteria implements ICrud<Ogrenci> {

    EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();


    @Override
    public List<Ogrenci> findAll() {
        CriteriaQuery<Ogrenci> criteria = criteriaBuilder.createQuery(Ogrenci.class);
        Root<Ogrenci> root = criteria.from(Ogrenci.class);
        criteria.select(root);
        List<Ogrenci> ogrenciList = entityManager.createQuery(criteria).getResultList();
        return ogrenciList;
    }

    @Override
    public Ogrenci findById(Long id) {
        CriteriaQuery<Ogrenci> criteria = criteriaBuilder.createQuery(Ogrenci.class);
        Root<Ogrenci> root = criteria.from(Ogrenci.class);
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"),id));
        Ogrenci ogrenci = entityManager.createQuery(criteria).getSingleResult();
        return ogrenci;
    }



}
