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

import com.latihan.kampus.dto.DosenReq;
import com.latihan.kampus.dto.DosenRes;
import com.latihan.kampus.service.DsnService;




@RestController
@RequestMapping("/api")
public class DsnController {

    @Autowired
    private DsnService dsnService;

    @GetMapping("/dosen")
    public ResponseEntity<DosenRes> getAllDosen() {
        DosenRes response = dsnService.getAllDosen();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/dosen/upload")
    public ResponseEntity<DosenRes> postMethodName(@RequestBody DosenReq req) {
        DosenRes response = dsnService.createDosen(req);
        return ResponseEntity.ok(response); 
    }

    @DeleteMapping("/dosen/delete")
    public ResponseEntity<DosenRes> deleteDosen(@RequestBody DosenReq req){
        DosenRes response = dsnService.deleteDosen(req);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/dosen/update")
    public ResponseEntity<DosenRes> updateDosen(@RequestBody DosenReq req){
        DosenRes response = dsnService.updateDosen(req);
        return ResponseEntity.ok(response);
    }
    
}
