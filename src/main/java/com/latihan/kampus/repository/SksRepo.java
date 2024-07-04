package com.latihan.kampus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.latihan.kampus.models.Semester;
import com.latihan.kampus.models.sks;

public interface SksRepo extends JpaRepository<sks, String>{
    @Query("SELECT new com.latihan.kampus.models.Semester(m.nim, m.nama,mt.nama, d.nama) " +
           "FROM Mahasiswa m " +
           "JOIN sks s ON s.mahasiswa.nim = m.nim " +
           "JOIN Dosmat dm ON dm.id = s.dosmat.id " +
           "JOIN Matkul mt ON mt.id = dm.matkul.id " +
           "JOIN Dosen d ON d.nid = dm.dosen.nid " +
           "ORDER BY mt.nama ASC")    
    List<Semester> getSemester();
}
