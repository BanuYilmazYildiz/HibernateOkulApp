package com.banu.controller;

import com.banu.repository.entity.Ogretmen;
import com.banu.service.OgretmenService;

import java.util.List;
import java.util.Optional;

public class OgretmenController {

    OgretmenService ogretmenService;

    public OgretmenController (){
        this.ogretmenService = new OgretmenService();
    }

    public Ogretmen save(Ogretmen ogretmen){
        return ogretmenService.save(ogretmen);
    }

    public void update (Ogretmen ogretmen){
        ogretmenService.update(ogretmen);
    }

    public List<Ogretmen> findAll() {
        return ogretmenService.findAll();
    }

    public Optional<Ogretmen> findById(Long id){
        return ogretmenService.findById(id);
    }
}
