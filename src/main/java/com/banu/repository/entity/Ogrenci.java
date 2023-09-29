package com.banu.repository.entity;

import com.banu.enums.EBrans;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_ogrenci")

public class Ogrenci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    private KisiselBilgiler kisiselBilgiler;


    @Builder.Default
    @Column(nullable = false)
    private LocalDate dogumTarihi=LocalDate.now();
}
