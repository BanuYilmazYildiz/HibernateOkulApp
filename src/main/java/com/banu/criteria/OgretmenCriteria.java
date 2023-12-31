package com.banu.criteria;

import com.banu.repository.entity.Ogretmen;
import com.banu.utility.HibernateUtility;
import com.banu.utility.ICrud;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;

public class OgretmenCriteria implements ICrud<Ogretmen> {

    EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

    @Override
    public List<Ogretmen> findAll() {
        CriteriaQuery<Ogretmen> criteria = criteriaBuilder.createQuery(Ogretmen.class);
        Root<Ogretmen> root = criteria.from(Ogretmen.class);
        criteria.select(root);
        List<Ogretmen> ogretmenList = entityManager.createQuery(criteria).getResultList();
        return ogretmenList;
    }

    @Override
    public Ogretmen findById(Long id) {
        CriteriaQuery<Ogretmen> criteria = criteriaBuilder.createQuery(Ogretmen.class);
        Root<Ogretmen> root = criteria.from(Ogretmen.class);
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"),id));
        Ogretmen ogretmen = entityManager.createQuery(criteria).getSingleResult();
        return ogretmen;
    }
}
