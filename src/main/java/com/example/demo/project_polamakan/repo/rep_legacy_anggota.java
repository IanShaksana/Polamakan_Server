package com.example.demo.project_polamakan.repo;

import com.example.demo.project_polamakan.table.legacy.legacy_anggota;
import org.springframework.data.jpa.repository.JpaRepository;

/*
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
*/
public interface rep_legacy_anggota extends JpaRepository<legacy_anggota, String> {

}