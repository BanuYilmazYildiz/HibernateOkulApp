package com.banu;

import com.banu.criteria.OgrenciCriteria;
import com.banu.criteria.OgretmenCriteria;
import com.banu.criteria.SinifCriteria;
import com.banu.dao.Ogrencidao;
import com.banu.dao.Ogretmendao;
import com.banu.dao.Sinifdao;
import com.banu.enums.EBrans;
import com.banu.repository.entity.KisiselBilgiler;
import com.banu.repository.entity.Ogrenci;
import com.banu.repository.entity.Ogretmen;
import com.banu.repository.entity.Sinif;
import com.banu.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();



        Ogretmen ogretmen = Ogretmen.builder()
                .kisiselBilgiler(KisiselBilgiler.builder().ad("Seyhun").soyad("Kipcak").tcKimlikNo("123456789").build())
                .brans(EBrans.KIMYA)
                .iseBaslamaTarihi(LocalDate.of(2003,10,25))
                .build();
        Ogretmen ogretmen1 = Ogretmen.builder()
                .kisiselBilgiler(KisiselBilgiler.builder().ad("Azmi").soyad("Okutan").tcKimlikNo("546874684").build())
                .brans(EBrans.FIZIK)
                .build();
        session.save(ogretmen);
        session.save(ogretmen1);


        Ogrenci ogrenci = Ogrenci.builder()
                .kisiselBilgiler(KisiselBilgiler.builder().ad("Esra").soyad("Murz").tcKimlikNo("1354568").build())
                .dogumTarihi(LocalDate.of(2005,1,24))
                .build();

        Ogrenci ogrenci1 = Ogrenci.builder()
                .kisiselBilgiler(KisiselBilgiler.builder().ad("Sare").soyad("Eryalcin").tcKimlikNo("65461245").build())
                .build();

        Sinif sinif = Sinif.builder()
                .sinifAdi("11A")
                .ogretmenId(ogretmen.getId())
                .ogrenciList(Arrays.asList(ogrenci.getKisiselBilgiler().getAd(),ogrenci1.getKisiselBilgiler().getAd()))
                .build();



        session.save(ogrenci);
        session.save(ogrenci1);
        session.save(sinif);

        transaction.commit();
        session.close();

        /*
        OgrenciCriteria ogrenciCriteria = new OgrenciCriteria();
        ogrenciCriteria.findAll().forEach(System.out::println);
        System.out.println("********************************");
        System.out.println(ogrenciCriteria.findById(2L));
         */


        /*
         OgretmenCriteria ogretmenCriteria = new OgretmenCriteria();
        ogretmenCriteria.findAll().forEach(System.out::println);
        System.out.println("********************************");
        System.out.println(ogretmenCriteria.findById(2L));
         */

        /*
        SinifCriteria sinifCriteria = new SinifCriteria();
       sinifCriteria.findAll().forEach(System.out::println);
        System.out.println("********************************");
        System.out.println(sinifCriteria.findById(1L));
        */

        Ogrencidao ogrencidao = new Ogrencidao();
        //ogrencidao.findAll();
        //ogrencidao.findById(1L);

        Ogretmendao ogretmendao = new Ogretmendao();
        //ogretmendao.findAll();
        //ogretmendao.findById(1L);

        Sinifdao sinifdao = new Sinifdao();
        //sinifdao.findAll();
        sinifdao.findById(1L);




    }



}