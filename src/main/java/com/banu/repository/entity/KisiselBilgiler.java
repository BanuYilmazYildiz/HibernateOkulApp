package com.banu.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class KisiselBilgiler {

    @Column(nullable = false,length = 30)
    private String ad;

    @Column(nullable = false,length = 30)
    private String soyad;

    @Column (nullable = false,unique = true,length = 11)
    private String tcKimlikNo;
}
