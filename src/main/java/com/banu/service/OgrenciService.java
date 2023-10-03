package com.banu.service;

import com.banu.repository.OgrenciRepository;
import com.banu.repository.entity.Ogrenci;

import java.util.List;
import java.util.Optional;

public class OgrenciService {

    OgrenciRepository ogrenciRepository;

    public OgrenciService(){
        this.ogrenciRepository = new OgrenciRepository();
    }

    public Ogrenci save(Ogrenci ogrenci){
        return ogrenciRepository.save(ogrenci);
    }

    public void update ( Ogrenci ogrenci){
        ogrenciRepository.update(ogrenci);
    }

    public List<Ogrenci> findAll(){
        return ogrenciRepository.findAll();
    }
    public Optional<Ogrenci> findById(Long id){
        return ogrenciRepository.findById(id);
    }
    public void saveAll(Iterable<Ogrenci> entites){
        ogrenciRepository.saveAll(entites);
    }

    public void delete(Ogrenci entity) {
        ogrenciRepository.delete(entity);
    }

    public void deleteById(Long id) {
        ogrenciRepository.deleteById(id);
    }

    public boolean existById(Long id) {
        return  ogrenciRepository.existById(id);
    }

    public List<Ogrenci> findByColumnNameAndValue(String columnName, String value) {
        return ogrenciRepository.findByColumnNameAndValue(columnName,value);
    }


}
