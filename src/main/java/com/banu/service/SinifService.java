package com.banu.service;

import com.banu.repository.SinifRepository;
import com.banu.repository.entity.Ogretmen;
import com.banu.repository.entity.Sinif;

import java.util.List;
import java.util.Optional;

public class SinifService {

    SinifRepository sinifRepository;

    public SinifService(){
        this.sinifRepository=new SinifRepository();
    }

    public Sinif save(Sinif sinif) {
        return sinifRepository.save(sinif);
    }
    public void update(Sinif sinif){
        sinifRepository.update(sinif);
    }

    public List<Sinif> findAll(){
        return sinifRepository.findAll();
    }

    public Optional<Sinif> findById(Long id){
        return sinifRepository.findById(id);
    }

    public void saveAll(Iterable<Sinif> entites){
        sinifRepository.saveAll(entites);
    }

    public void delete(Sinif entity) {
        sinifRepository.delete(entity);
    }

    public void deleteById(Long id) {
        sinifRepository.deleteById(id);
    }

    public boolean existById(Long id) {
        return  sinifRepository.existById(id);
    }

    public List<Sinif> findByColumnNameAndValue(String columnName, String value) {
        return sinifRepository.findByColumnNameAndValue(columnName,value);
    }
}
