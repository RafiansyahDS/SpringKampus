package com.latihan.kampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.latihan.kampus.dto.MahasiswaReq;
import com.latihan.kampus.dto.MahasiswaRes;
import com.latihan.kampus.service.MhsService;

@RestController
@RequestMapping("/api")
public class MhsController {
     @Autowired
    private MhsService mhsService;
 @GetMapping("/mahasiswa")
    public ResponseEntity<MahasiswaRes> getAllMahasiswa() {
        MahasiswaRes response = mhsService.getAllMahasiswa();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/mahasiswa/nim")
    public ResponseEntity<MahasiswaRes> getMahasiswaByNim(@RequestBody MahasiswaReq req) {
        MahasiswaRes response = mhsService.getMahasiswaByNim(req);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/mahasiswa/gender")
    public ResponseEntity<MahasiswaRes> getMahasiswaByGender(@RequestBody MahasiswaReq req) {
        MahasiswaRes response = mhsService.getAllMahasiswaByGender(req);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/mahasiswa/upload")
    public ResponseEntity<MahasiswaRes> uploadMahasiswa(@RequestBody MahasiswaReq req) {
        MahasiswaRes response = mhsService.createMahasiswa(req);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/mahasiswa/delete")
    public ResponseEntity<MahasiswaRes> deleteMahasiswa(@RequestBody MahasiswaReq req){
        MahasiswaRes response = mhsService.deleteMahasiswa(req);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/mahasiswa/update")
    public ResponseEntity<MahasiswaRes> updateMahasiswa(@RequestBody MahasiswaReq req){
        MahasiswaRes response = mhsService.updateMahasiswa(req);
        return ResponseEntity.ok(response);
    }
}
