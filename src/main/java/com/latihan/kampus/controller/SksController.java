package com.latihan.kampus.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.latihan.kampus.dto.KelasRes;
import com.latihan.kampus.dto.MatkulRes;
import com.latihan.kampus.dto.SemesterRes;
import com.latihan.kampus.service.SksService;

@RestController
@RequestMapping("/api")
public class SksController {
    @Autowired
    private SksService sksService;

    @GetMapping("/kelas")
    public ResponseEntity<KelasRes> getKelas() {
        KelasRes response = sksService.getKelas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/semester")
    public ResponseEntity<SemesterRes> getSemesteString() {
        SemesterRes response = sksService.getSemester();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/matkul")
    public ResponseEntity<MatkulRes> getAllMatkul() {
        MatkulRes response = sksService.getMatkul();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/semester/create-report")
    public void createSemesterReport(HttpServletResponse res){
        sksService.createSemesterReport(res);
    }

    @GetMapping("/kelas/create-report")
    public void createKelasReport(HttpServletResponse res){
        sksService.createKelasReport(res);
    }
}
