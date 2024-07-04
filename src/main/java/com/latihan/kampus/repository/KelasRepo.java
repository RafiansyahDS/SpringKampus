package com.latihan.kampus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.latihan.kampus.models.Dosmat;
import com.latihan.kampus.models.Kelas;

public interface KelasRepo extends JpaRepository<Dosmat, String> {
    @Query("SELECT new com.latihan.kampus.models.Kelas(d.nama, m.nama) " +
           "FROM Dosmat dm " +
           "JOIN dm.dosen d " +
           "JOIN dm.matkul m")
    List<Kelas> getKelas();
}
