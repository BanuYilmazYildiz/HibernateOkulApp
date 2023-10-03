package com.banu.repository;


import com.banu.repository.entity.Ogretmen;
import com.banu.utility.MyFactoryRepository;



public class OgretmenRepository extends MyFactoryRepository<Ogretmen,Long> {

    public OgretmenRepository(){
        super(new Ogretmen());
    }


}
