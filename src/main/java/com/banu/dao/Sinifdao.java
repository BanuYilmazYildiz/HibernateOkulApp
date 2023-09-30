package com.banu.dao;

import com.banu.repository.entity.Sinif;
import com.banu.utility.HibernateUtility;
import com.banu.utility.ICrud;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class Sinifdao implements ICrud<Sinif> {
    Session session = HibernateUtility.getSessionFactory().openSession();
    @Override
    public List<Sinif> findAll() {
        String hql ="FROM Sinif";
        Query query = session.createQuery(hql);
        List<Sinif> sinifList = query.getResultList();
        sinifList.forEach(System.out::println);
        return sinifList;
    }

    @Override
    public Sinif findById(Long id) {
        String hql = "FROM Sinif WHERE id =: deger";
        Query query = session.createQuery(hql);
        Sinif sinif = (Sinif) query.setParameter("deger",id).getSingleResult();
        System.out.println(sinif);
        return sinif;
    }
}
