package com.latihan.kampus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latihan.kampus.dto.MahasiswaDTO;
import com.latihan.kampus.dto.MahasiswaReq;
import com.latihan.kampus.dto.MahasiswaRes;
import com.latihan.kampus.models.Mahasiswa;
import com.latihan.kampus.repository.MhsRepo;

@Service
public class MhsServiceImpl implements MhsService {

    private static final Logger logger = Logger.getLogger(MhsServiceImpl.class.getName());

    @Autowired
    private MhsRepo mhsRepo;


    @Override
    public MahasiswaRes createMahasiswa(MahasiswaReq req) {
        MahasiswaRes response = new MahasiswaRes();
        try{
            Optional<Mahasiswa> mhs = mhsRepo.findById(req.getNim());
             if(!mhs.isPresent()){
                Mahasiswa m = new Mahasiswa();
                m.setNama(req.getNama());
                m.setGender(req.getGender());
                m.setNim(req.getNim());
                m.setAddres(req.getAddres());
                mhsRepo.save(m);
                response.setMessage("Berhasil");
                response.setStatus("200");
             }else{
                response.setStatus("500");
                response.setMessage("Gagal");
             }
        }catch(Exception e){
            response.setStatus("500");
            response.setMessage("Gagal");
            logger.severe(e.toString());
        }
        return response;
    }

    @Override
    public MahasiswaRes getAllMahasiswa() {
        MahasiswaRes response = new MahasiswaRes();
        try {
            List<Mahasiswa> mhs = mhsRepo.findAll();
            List<MahasiswaDTO> req = new ArrayList<>();
            for(Mahasiswa m: mhs){
                MahasiswaDTO mr = new MahasiswaDTO();
                mr.setNama(m.getNama());
                mr.setAddres(m.getAddres());
                mr.setGender(m.getGender());
                mr.setNim(m.getNim());
                req.add(mr);
            }
            response.setMahasiswaList(req);
            response.setStatus("200");
            response.setMessage("Berhasil");
        } catch (Exception e) {
            response.setMessage("Gagal");
            response.setStatus("200");
            logger.severe(e.toString());
        }
        return response;
    }

    @Override
    public MahasiswaRes getAllMahasiswaByGender(MahasiswaReq req) {
        MahasiswaRes response = new MahasiswaRes();
        try {
            List<Mahasiswa> mhs = mhsRepo.getMahasiswaByGender(req.getGender());
            if(!mhs.isEmpty()){
                List<MahasiswaDTO> mdto = new ArrayList<>();
                for(Mahasiswa m: mhs){
                    MahasiswaDTO mr = new MahasiswaDTO();
                    mr.setNama(m.getNama());
                    mr.setAddres(m.getAddres());
                    mr.setGender(m.getGender());
                    mr.setNim(m.getNim());
                    mdto.add(mr);
                }
                response.setMahasiswaList(mdto);
                response.setStatus("200");
                response.setMessage("Berhasil");
            }else{
                response.setStatus("404");
                response.setMessage("Data tidak ditemukan");
            }
        } catch (Exception e) {
            response.setStatus("500");
            response.setMessage("Gagal");
            logger.severe(e.toString());
        }
        return response;
    }

    @Override
    public MahasiswaRes getMahasiswaByNim(MahasiswaReq req) {
        MahasiswaRes response = new MahasiswaRes();
        try {
            Optional<Mahasiswa> data = mhsRepo.findById(req.getNim());
            if(data.isPresent()){
                Mahasiswa m = data.get();
                MahasiswaDTO mdto = new MahasiswaDTO();
                List<MahasiswaDTO> list = new ArrayList<>();
                mdto.setNama(m.getNama());
                mdto.setNim(m.getNim());
                mdto.setGender(m.getGender());
                mdto.setAddres(m.getAddres());
                list.add(mdto);
                response.setMahasiswaList(list);
                response.setStatus("200");
                response.setMessage("Berhasil");
            }else{
                response.setStatus("404");
                response.setMessage("Data tidak ditemukan");
            }
        } catch (Exception e) {
            response.setStatus("500");
            response.setMessage("Gagal");
            logger.severe(e.toString());
        }
        return response;
    }

    @Override
    public MahasiswaRes updateMahasiswa(MahasiswaReq req) {
        MahasiswaRes response = new MahasiswaRes();
        try {
            Optional<Mahasiswa> mhs = mhsRepo.findById(req.getNim());
            if(mhs.isPresent()){
                Mahasiswa m = mhs.get();
                m.setNim(req.getNim());
                m.setNama(req.getNama());
                m.setGender(req.getGender());
                m.setAddres(req.getAddres());
                mhsRepo.save(m);
                response.setStatus("200");
                response.setMessage("Berhasil");
            }else{
                response.setStatus("404");
                response.setMessage("Gagal, data tidak ditemukan");
            }
        } catch (Exception e) {
            response.setStatus("500");
            response.setMessage("Gagal");
            logger.severe(e.toString());
        }
        return response;
    }

    @Override
    public MahasiswaRes deleteMahasiswa(MahasiswaReq req) {
        MahasiswaRes response = new MahasiswaRes();
        try {
            Optional<Mahasiswa> mhs = mhsRepo.findById(req.getNim());
            if(mhs.isPresent()){
                mhsRepo.deleteById(req.getNim());
                response.setStatus("200");
                response.setMessage("Berhasil");
            }else{
                response.setStatus("500");
                response.setMessage("Gagal");
            }
        } catch (Exception e) {
            response.setStatus("500");
            response.setMessage("Gagal");
            logger.severe(e.toString());
        }
        return response;
    }

    

    
}
