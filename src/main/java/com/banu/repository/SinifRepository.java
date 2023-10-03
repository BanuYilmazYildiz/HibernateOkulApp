package com.banu.repository;


import com.banu.repository.entity.Sinif;

import com.banu.utility.MyFactoryRepository;



public class SinifRepository extends MyFactoryRepository<Sinif,Long> {

    public SinifRepository(){
        super(new Sinif());
    }


}
