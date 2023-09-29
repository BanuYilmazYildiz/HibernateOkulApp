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
@Table(name = "tbl_ogretmen")
public class Ogretmen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    private KisiselBilgiler kisiselBilgiler;

    @Enumerated(EnumType.STRING)
    private EBrans brans;

    @Builder.Default
    @Column(nullable = false)
    private LocalDate iseBaslamaTarihi=LocalDate.now();



}
