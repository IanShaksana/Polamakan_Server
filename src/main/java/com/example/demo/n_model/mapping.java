package com.example.demo.n_model;

import java.util.*;

/**
 *
 * @author Adrian
 */
public class mapping {

    private Map<Integer, String> mapping1;
    private Map<String, String> mapping2;
    private Map<Integer, String> mapping_batch1;
    private Map<String, String> mapping_batch2;

    public mapping() {

        mapping1 = new HashMap<>();
        mapping1.put(1, "No. Member");
        mapping1.put(2, "Timestamp");
        mapping1.put(3, "Nama");
        mapping1.put(4, "Nomor Ponsel (WhatsApp)");
        mapping1.put(5, "Username Instagram");
        mapping1.put(6, "Birth Date");
        mapping1.put(7, "Jenis Kelamin");
        mapping1.put(8, "Tinggi Badan (cm)");
        mapping1.put(9, "Berat Badan (kg)");
        mapping1.put(10, "Usia (tahun)");
        mapping1.put(11, "Golongan Darah");
        mapping1.put(12, "Aktivitas Fisik");
        mapping1.put(13, "Tujuan Diet");
        mapping1.put(14, "Paket Pilihan");
        mapping1.put(15, "Alamat Pengiriman Lunch");
        mapping1.put(16, "Alamat Pengiriman Dinner");
        mapping1.put(17, "Preferensi Karbo");
        mapping1.put(18, "Alergi Daging");
        mapping1.put(19, "Alergi Sayur & Lainnya");
        mapping1.put(20, "Special Note");
        mapping1.put(21, "Dari mana Anda mengetahui polamakan.id?");
        mapping1.put(22, "Nama Referensi");
        mapping1.put(23, "");
        mapping1.put(24, "BMI");
        mapping1.put(25, "BMI Category");
        mapping1.put(26, "Ideal Weight");
        mapping1.put(27, "Selisih");
        mapping1.put(28, "BMR (kkal)");
        mapping1.put(29, "TDEE (kkal)");
        mapping1.put(30, "Lunch/Dinner (30%)");
        mapping1.put(31, "Meals by Purpose");
        mapping1.put(32, "Kategori");
        mapping1.put(33, "Jenis Paket");

        mapping2 = new HashMap<>();
        mapping2.put("No. Member", "noMember");
        mapping2.put("Nama", "nama");
        mapping2.put("Nomor Ponsel (WhatsApp)", "telp");
        mapping2.put("Username Instagram", "ig");
        mapping2.put("Birth Date", "tglLahir");
        mapping2.put("Jenis Kelamin", "jenisKelamin");
        mapping2.put("Tinggi Badan (cm)", "tinggiBadan");
        mapping2.put("Berat Badan (kg)", "beratBadan");
        mapping2.put("Usia (tahun)", "usia");
        mapping2.put("Golongan Darah", "golonganDarah");
        mapping2.put("Aktivitas Fisik", "aktifitasFisik");
        mapping2.put("Tujuan Diet", "tujuanDiet");
        mapping2.put("Paket Pilihan", "paketPilihan");
        mapping2.put("Alamat Pengiriman Lunch", "alamatLunch");
        mapping2.put("Alamat Pengiriman Dinner", "alamatDinner");
        mapping2.put("Preferensi Karbo", "prefKarbo");
        mapping2.put("Alergi Daging", "alergiDaging");
        mapping2.put("Alergi Sayur & Lainnya", "alergiSayur");
        mapping2.put("Special Note", "specialNote");
        mapping2.put("Dari mana Anda mengetahui polamakan.id?", "info");
        mapping2.put("Nama Referensi", "namaRef");
        mapping2.put("BMI", "bmi");
        mapping2.put("BMI Category", "bmiCategory");
        mapping2.put("Ideal Weight", "idealWeight");
        mapping2.put("Selisih", "selisih");
        mapping2.put("BMR (kkal)", "bmrKkal");
        mapping2.put("TDEE (kkal)", "tdeeKkal");
        mapping2.put("Lunch/Dinner (30%)", "lunchDinner");
        mapping2.put("Meals by Purpose", "mealBypurpose");
        mapping2.put("Kategori", "kategori");
        mapping2.put("Jenis Paket", "jenisPaket");

        mapping_batch1 = new HashMap<>();
        mapping_batch1.put(1, "NO MEMBER");
        mapping_batch1.put(2, "NO MEMBER");
        mapping_batch1.put(3, "NAMA");
        mapping_batch1.put(4, "LUNCH?");
        mapping_batch1.put(5, "DINNER?");
        mapping_batch1.put(6, "NOTE ADMIN");
        mapping_batch1.put(7, "IKUT SAMPAI BATCH");
        mapping_batch1.put(8, "NOTE DELIVERY");
        mapping_batch1.put(9, "NOTE KITCHEN");
        mapping_batch1.put(10, "TIPE CUSTOMER");
        mapping_batch1.put(11, "BAYAR");
        

        mapping_batch2 = new HashMap<>();
        mapping_batch2.put("NO MEMBER", "noMember");
        mapping_batch2.put("NAMA", "nama");
        mapping_batch2.put("LUNCH?", "lunch");
        mapping_batch2.put("DINNER?", "dinner");
        mapping_batch2.put("NOTE ADMIN", "noteAdmin");
        mapping_batch2.put("IKUT SAMPAI BATCH", "batchNumber");
        mapping_batch2.put("NOTE DELIVERY", "noteDelivery");
        mapping_batch2.put("NOTE KITCHEN", "noteKitchen");
        mapping_batch2.put("TIPE CUSTOMER", "tipeCustomer");
        mapping_batch2.put("BAYAR", "bayar");
        mapping_batch2.put("nama", "namaReal");
        mapping_batch2.put("kode", "kode");
        mapping_batch2.put("no hape", "nohp");
        mapping_batch2.put("alamat lunch", "alamatLunch");
        mapping_batch2.put("alamat dinner", "alamatDinner");
        mapping_batch2.put("pilihan karbo", "prefKarbo");
        mapping_batch2.put("alergi daging", "alergiDaging");
        mapping_batch2.put("alergi sayur", "alergiSayur");
        mapping_batch2.put("special note", "specialNote");

    }

    public Map<Integer, String> getMapping1() {
        return mapping1;
    }

    public Map<String, String> getMapping2() {
        return mapping2;
    }

    public Map<Integer, String> getMapping3() {
        return mapping_batch1;
    }

    public Map<String, String> getMapping4() {
        return mapping_batch2;
    }



}
