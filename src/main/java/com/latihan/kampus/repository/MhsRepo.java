package com.latihan.kampus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.latihan.kampus.models.Mahasiswa;

@Repository
public interface MhsRepo extends JpaRepository<Mahasiswa, String> {
    @Query("SELECT m FROM Mahasiswa m WHERE m.gender = :gender")
    public List<Mahasiswa> getMahasiswaByGender(String gender);
}
