package com.banu.dao;

import com.banu.repository.entity.Ogrenci;
import com.banu.utility.HibernateUtility;
import com.banu.utility.ICrud;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class Ogrencidao implements ICrud<Ogrenci> {
    Session session = HibernateUtility.getSessionFactory().openSession();
    @Override
    public List<Ogrenci> findAll() {

        String hql = "FROM Ogrenci";
        Query query = session.createQuery(hql);
        List<Ogrenci> ogrenciList = query.getResultList();
        ogrenciList.forEach(System.out::println);
        return ogrenciList;
    }

    @Override
    public Ogrenci findById(Long id) {
        String hql = "FROM Ogrenci WHERE id =: deger";
        Query query = session.createQuery(hql);
        Ogrenci ogrenci = (Ogrenci) query.setParameter("deger", id).getSingleResult();
        System.out.println(ogrenci);
        return ogrenci;
    }
}
