package com.banu.repository;


import com.banu.repository.entity.Ogrenci;
import com.banu.utility.MyFactoryRepository;

public class OgrenciRepository  extends MyFactoryRepository<Ogrenci,Long> {


    public OgrenciRepository() {
        super(new Ogrenci());
    }


}
