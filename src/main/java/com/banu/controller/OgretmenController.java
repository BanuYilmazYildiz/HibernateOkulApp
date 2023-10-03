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

    public void saveAll(Iterable<Ogretmen> entites){
        ogretmenService.saveAll(entites);
    }

    public void delete(Ogretmen entity) {
        ogretmenService.delete(entity);
    }

    public void deleteById(Long id) {
        ogretmenService.deleteById(id);
    }

    public boolean existById(Long id) {
        return  ogretmenService.existById(id);
    }

    public List<Ogretmen> findByColumnNameAndValue(String columnName, String value) {
        return ogretmenService.findByColumnNameAndValue(columnName,value);
    }
}
