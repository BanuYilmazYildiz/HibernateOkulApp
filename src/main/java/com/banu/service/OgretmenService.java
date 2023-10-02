package com.banu.service;

import com.banu.repository.OgrenciRepository;
import com.banu.repository.OgretmenRepository;
import com.banu.repository.entity.Ogrenci;
import com.banu.repository.entity.Ogretmen;

import java.util.List;
import java.util.Optional;

public class OgretmenService {

    OgretmenRepository ogretmenRepository;

    public OgretmenService(){
        this.ogretmenRepository=new OgretmenRepository();
    }



    public Ogretmen save(Ogretmen ogretmen){
        return ogretmenRepository.save(ogretmen);
    }

    public void update ( Ogretmen ogretmen){
        ogretmenRepository.update(ogretmen);
    }

    public List< Ogretmen> findAll(){
        return ogretmenRepository.findAll();
    }
    public Optional< Ogretmen> findById(Long id){
        return ogretmenRepository.findById(id);
    }

}
