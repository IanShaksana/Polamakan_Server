package com.example.demo.project_polamakan.repo;

import java.util.List;

import com.example.demo.project_polamakan.table.dftr_batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/*
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional; 
*/
public interface rep_batch extends JpaRepository<dftr_batch, String> {
    dftr_batch findByJsonencode(String jsonencode);

    dftr_batch findByNoMember(String noMember);

    List<dftr_batch> findByBatchNumberOrderByNama(String batchNumber);

    @Query(value = "SELECT * from dftr_batch INNER JOIN dftr_anggota ON dftr_batch.no_member = dftr_anggota.no_member AND dftr_batch.batch_number = :a ORDER by dftr_anggota.alamat_lunch, dftr_anggota.nama", nativeQuery = true)
    List<dftr_batch> findalamatlunch(@Param("a") String batchNumber);

    @Query(value = "SELECT * from dftr_batch INNER JOIN dftr_anggota ON dftr_batch.no_member = dftr_anggota.no_member AND dftr_batch.batch_number = :a ORDER by dftr_anggota.alamat_dinner, dftr_anggota.nama", nativeQuery = true)
    List<dftr_batch> findalamatdinner(@Param("a") String batchNumber);
}