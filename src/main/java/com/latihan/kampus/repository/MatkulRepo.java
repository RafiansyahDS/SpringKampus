package com.latihan.kampus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.latihan.kampus.models.Matkul;

@Repository
public interface MatkulRepo extends JpaRepository<Matkul, String> {
    
}
