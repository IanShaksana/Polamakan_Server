package com.example.demo.project_polamakan.table;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import lombok.*;

@Entity
@Getter
@Setter

public class dftr_batch {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 50)
    private String id;

    @Column(length = 50)
    private String noMember = "none";
    // real, pake referensi
    @Column(length = 50)
    private String nama = "none";

    @Column(columnDefinition = "LONGTEXT")
    private String lunch = "none";
    @Column(columnDefinition = "LONGTEXT")
    private String dinner = "none";
    @Column(columnDefinition = "LONGTEXT")
    private String noteAdmin = "none";

    @Column(length = 50)
    private String batchNumber = "none";

    @Column(columnDefinition = "LONGTEXT")
    private String noteDelivery = "none";
    @Column(columnDefinition = "LONGTEXT")
    private String noteKitchen = "none";

    @Column(length = 50)
    private String tipeCustomer = "none";
    @Column(length = 50)
    private String bayar = "none";

    @Column(length = 50)
    private String namareal = "none";
    // @Column(length = 50)
    // private String kode;

    // @Column(length = 50)
    // private String nohp;

    // // real, pake referensi
    // @Column(columnDefinition = "LONGTEXT")
    // private String alamatLunch;
    // // real, pake referensi
    // @Column(columnDefinition = "LONGTEXT")
    // private String alamatDinner;

    // // real, pake referensi
    // @Column(columnDefinition = "LONGTEXT")
    // private String prefKarbo;
    // // real, pake referensi
    // @Column(columnDefinition = "LONGTEXT")
    // private String alergiDaging;
    // // real, pake referensi
    // @Column(columnDefinition = "LONGTEXT")
    // private String alergiSayur;
    // // ada note kicthen buat apa ini ???
    // @Column(columnDefinition = "LONGTEXT")
    // private String specialNote;

    @Column(length = 50)
    private Integer version = 0;
    @Column(columnDefinition = "LONGTEXT")
    private String jsonencode;

}