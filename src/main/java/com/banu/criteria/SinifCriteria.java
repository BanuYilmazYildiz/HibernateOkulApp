package com.banu.criteria;

import com.banu.repository.entity.Sinif;
import com.banu.utility.HibernateUtility;
import com.banu.utility.ICrud;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class SinifCriteria implements ICrud<Sinif> {
    EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    @Override
    public List<Sinif> findAll() {
        CriteriaQuery<Sinif> criteria = criteriaBuilder.createQuery(Sinif.class);
        Root<Sinif> root = criteria.from(Sinif.class);
        criteria.select(root);
        List<Sinif> sinifList = entityManager.createQuery(criteria).getResultList();
        return sinifList;
    }

    @Override
    public Sinif findById(Long id) {
        CriteriaQuery<Sinif> criteria = criteriaBuilder.createQuery(Sinif.class);
        Root<Sinif> root = criteria.from(Sinif.class);
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"),id));
        Sinif sinif = entityManager.createQuery(criteria).getSingleResult();
        return sinif;
    }
}
