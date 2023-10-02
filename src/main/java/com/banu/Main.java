package com.banu;

import com.banu.controller.OgrenciController;
import com.banu.controller.OgretmenController;
import com.banu.controller.SinifController;
import com.banu.enums.EBrans;
import com.banu.repository.entity.Ogretmen;
import com.banu.repository.entity.Sinif;
import com.banu.repository.hql.Ogrencidao;
import com.banu.repository.OgrenciRepository;
import com.banu.repository.entity.KisiselBilgiler;
import com.banu.repository.entity.Ogrenci;
import com.banu.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {



//        Session session = HibernateUtility.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//
        Ogrenci ogrenci = Ogrenci.builder()
                .kisiselBilgiler(KisiselBilgiler.builder().ad("Mehmet").soyad("Yilmaz").tcKimlikNo("154418").build())
                .dogumTarihi(LocalDate.of(1997,2,14))
                .build();

//        session.save(ogrenci);
//        transaction.commit();
//        session.close();

//
//
//
//        Ogretmen ogretmen = Ogretmen.builder()
//                .kisiselBilgiler(KisiselBilgiler.builder().ad("Seyhun").soyad("Kipcak").tcKimlikNo("123456789").build())
//                .brans(EBrans.KIMYA)
//                .iseBaslamaTarihi(LocalDate.of(2003,10,25))
//                .build();
//        Ogretmen ogretmen1 = Ogretmen.builder()
//                .kisiselBilgiler(KisiselBilgiler.builder().ad("Azmi").soyad("Okutan").tcKimlikNo("546874684").build())
//                .brans(EBrans.FIZIK)
//                .build();
//        session.save(ogretmen);
//        session.save(ogretmen1);
//
//
//        Ogrenci ogrenci = Ogrenci.builder()
//                .kisiselBilgiler(KisiselBilgiler.builder().ad("Esra").soyad("Murz").tcKimlikNo("1354568").build())
//                .dogumTarihi(LocalDate.of(2005,1,24))
//                .build();
//
//        Ogrenci ogrenci1 = Ogrenci.builder()
//                .kisiselBilgiler(KisiselBilgiler.builder().ad("Sare").soyad("Eryalcin").tcKimlikNo("65461245").build())
//                .build();
//
//        Sinif sinif = Sinif.builder()
//                .sinifAdi("11A")
//                .ogretmenId(ogretmen.getId())
//                .ogrenciList(Arrays.asList(ogrenci.getKisiselBilgiler().getAd(),ogrenci1.getKisiselBilgiler().getAd()))
//                .build();
//
//
//
//        session.save(ogrenci);
//        session.save(ogrenci1);
//        session.save(sinif);
//
//        transaction.commit();
//        session.close();










        /*
        SinifCriteria sinifCriteria = new SinifCriteria();
       sinifCriteria.findAll().forEach(System.out::println);
        System.out.println("********************************");
        System.out.println(sinifCriteria.findById(1L));
        */



//        Ogretmendao ogretmendao = new Ogretmendao();
//        //ogretmendao.findAll();
//        //ogretmendao.findById(1L);
//
//        Sinifdao sinifdao = new Sinifdao();
//        //sinifdao.findAll();
//        sinifdao.findById(1L);

//        Ogrenci ogrenci = Ogrenci.builder()
//                .kisiselBilgiler(KisiselBilgiler.builder().ad("Banu").soyad("Yilmaz Yildi<").tcKimlikNo("26656201085").build())
//                .dogumTarihi(LocalDate.of(1996,9,9))
//                .build();
//        OgrenciController ogrenciController = new OgrenciController();
//        ogrenciController.save(ogrenci);

        Ogretmen ogretmen = Ogretmen.builder()
                .kisiselBilgiler(KisiselBilgiler.builder().ad("Nurten").soyad("Kucuk").tcKimlikNo("5897877").build())
                .brans(EBrans.MATEMETIK)
                .iseBaslamaTarihi(LocalDate.of(1975,6,10))
                .build();
        OgretmenController ogretmenController = new OgretmenController();
        ogretmenController.save(ogretmen);

        Sinif sinif = Sinif.builder()
                .sinifAdi("9C")
                .ogretmenId(ogretmen.getId())
                .ogrenciList(Arrays.asList(ogrenci.getKisiselBilgiler().getAd()))
                .build();
        SinifController sinifController = new SinifController();
        sinifController.save(sinif);




    }



}