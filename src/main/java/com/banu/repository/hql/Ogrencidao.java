package com.banu.repository.hql;

import com.banu.repository.entity.Ogrenci;
import com.banu.utility.HibernateUtility;
import com.banu.utility.ICrud;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class Ogrencidao implements ICrud<Ogrenci,Long> {
    Session session = HibernateUtility.getSessionFactory().openSession();
    private final EntityManager  entityManager= HibernateUtility.getSessionFactory().createEntityManager();

    @Override
    public Ogrenci save(Ogrenci entity) {
        return null;
    }

    @Override
    public void update(Ogrenci entity) {

    }

    @Override
    public List<Ogrenci> findAll() {

        String hql = "FROM Ogrenci";
        Query query = session.createQuery(hql);
        List<Ogrenci> ogrenciList = query.getResultList();
        ogrenciList.forEach(System.out::println);
        return ogrenciList;
    }

    public List<Ogrenci> findAll2() {
        String hql = "SELECT o FROM Ogrenci o";
        TypedQuery<Ogrenci> query = entityManager.createQuery(hql, Ogrenci.class);
        return query.getResultList();
    }

    @Override
    public Optional<Ogrenci> findById(Long id) {
        String hql = "FROM Ogrenci WHERE id =: deger";
        Query query = session.createQuery(hql);
        Ogrenci ogrenci = (Ogrenci) query.setParameter("deger", id).getSingleResult();
        System.out.println(ogrenci);
        return Optional.ofNullable(ogrenci);
    }

    @Override
    public void saveAll(Iterable<Ogrenci> entites) {

    }

    @Override
    public void delete(Ogrenci entity) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public boolean existById(Long aLong) {
        return false;
    }

    @Override
    public List<Ogrenci> findByColumnNameAndValue(String columnName, String value) {
        return null;
    }

    public Optional<Ogrenci> findById2(Long id) {
        return Optional.ofNullable(entityManager.find(Ogrenci.class,id));
    }

}
