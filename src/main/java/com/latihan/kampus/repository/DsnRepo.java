package com.latihan.kampus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.latihan.kampus.models.Dosen;

@Repository
public interface DsnRepo extends JpaRepository<Dosen, String>{
    @Query("SELECT d FROM Dosen d WHERE d.gender = :gender")
    public List<Dosen> getAllDosenByGender(String gender);
}
