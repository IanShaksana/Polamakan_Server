package com.example.demo.project_polamakan.table;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter

public class dftr_anggota {
    @Id
    @Column(length = 50)
    private String noMember = "none";

    @Column(length = 50)
    private String nama = "none";
    @Column(length = 50)
    private String telp = "none";
    @Column(length = 50)
    private String ig = "none";
    @Column(length = 50)
    private String tglLahir = "none";
    @Column(length = 50)
    private String jenisKelamin = "none";
    @Column(length = 50)
    private String tinggiBadan = "none";
    @Column(length = 50)
    private String beratBadan = "none";
    @Column(length = 50)
    private String usia = "none";
    @Column(length = 50)
    private String golonganDarah = "none";
    @Column(columnDefinition = "LONGTEXT")
    private String aktifitasFisik = "none";
    @Column(columnDefinition = "LONGTEXT")
    private String tujuanDiet = "none";
    @Column(columnDefinition = "LONGTEXT")
    private String paketPilihan = "none";    
    @Column(columnDefinition = "LONGTEXT")
    private String alamatLunch = "none";    
    @Column(columnDefinition = "LONGTEXT")
    private String alamatDinner = "none";
    @Column(columnDefinition = "LONGTEXT")
    private String prefKarbo = "none";
    @Column(columnDefinition = "LONGTEXT")
    private String alergiDaging = "none";
    @Column(columnDefinition = "LONGTEXT")
    private String alergiSayur = "none";
    @Column(columnDefinition = "LONGTEXT")
    private String specialNote = "none";
    @Column(columnDefinition = "LONGTEXT")
    private String info = "none";
    @Column(columnDefinition = "LONGTEXT")
    private String namaRef = "none";
    @Column(length = 50)
    private String bmi = "none";
    @Column(length = 50)
    private String bmiCategory = "none";
    @Column(length = 50)
    private String idealWeight = "none";
    @Column(length = 50)
    private String selisih = "none";
    @Column(length = 50)
    private String bmrKkal = "none";
    @Column(length = 50)
    private String tdeeKkal = "none";
    @Column(length = 50)
    private String lunchDinner = "none";
    @Column(length = 50)
    private String mealBypurpose = "none";
    @Column(length = 50)
    private String kategori = "none";
    @Column(length = 50)
    private String jenisPaket = "none";

    @Column(length = 50)
    private Integer version = 0;
    @Column(columnDefinition = "LONGTEXT")
    private String jsonencode = "none";


}