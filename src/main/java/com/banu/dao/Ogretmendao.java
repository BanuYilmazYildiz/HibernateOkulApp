package com.banu.dao;

import com.banu.repository.entity.Ogretmen;
import com.banu.utility.HibernateUtility;
import com.banu.utility.ICrud;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class Ogretmendao implements ICrud<Ogretmen> {
    Session session = HibernateUtility.getSessionFactory().openSession();
    @Override
    public List<Ogretmen> findAll() {
       String hql = "FROM Ogretmen";
        Query query = session.createQuery(hql);
        List<Ogretmen> ogretmenList = query.getResultList();
        ogretmenList.forEach(System.out::println);
        return ogretmenList;
    }

    @Override
    public Ogretmen findById(Long id) {
        String hql = "FROM Ogretmen WHERE id =: deger";
        Query query = session.createQuery(hql);
        Ogretmen ogretmen = (Ogretmen) query.setParameter("deger",id).getSingleResult();
        System.out.println(ogretmen);
        return ogretmen;
    }
}
