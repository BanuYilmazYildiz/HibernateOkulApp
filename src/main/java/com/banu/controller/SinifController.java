package com.banu.controller;

import com.banu.repository.entity.Sinif;
import com.banu.service.SinifService;

import java.util.List;
import java.util.Optional;

public class SinifController {

    SinifService sinifService;

    public  SinifController(){
        this.sinifService = new SinifService();
    }

    public Sinif save(Sinif sinif){
        return sinifService.save(sinif);
    }

    public void update (Sinif sinif){
        sinifService.update(sinif);
    }

    public List<Sinif> findAll(){
        return sinifService.findAll();
    }

    public Optional<Sinif> findById(Long id){
        return sinifService.findById(id);
    }

    public void saveAll(Iterable<Sinif> entites){
        sinifService.saveAll(entites);
    }

    public void delete(Sinif entity) {
        sinifService.delete(entity);
    }

    public void deleteById(Long id) {
        sinifService.deleteById(id);
    }

    public boolean existById(Long id) {
        return  sinifService.existById(id);
    }

    public List<Sinif> findByColumnNameAndValue(String columnName, String value) {
        return sinifService.findByColumnNameAndValue(columnName,value);
    }
}
