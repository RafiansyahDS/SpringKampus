package com.latihan.kampus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latihan.kampus.dto.DosenDTO;
import com.latihan.kampus.dto.DosenReq;
import com.latihan.kampus.dto.DosenRes;
import com.latihan.kampus.models.Dosen;
import com.latihan.kampus.repository.DsnRepo;

@Service
public class DsnServiceImpl implements DsnService{

    private static final Logger logger = Logger.getLogger(DsnServiceImpl.class.getName());

    @Autowired
    private DsnRepo dsnRepo;

    @Override
    public DosenRes createDosen(DosenReq req) {
        DosenRes response = new DosenRes();
        try{
            Optional<Dosen> check = dsnRepo.findById(req.getNid());
            if(!check.isPresent()){
                Dosen dsn = new Dosen();
                dsn.setNid(req.getNid());
                dsn.setNama(req.getNama());
                dsn.setAddres(req.getAddres());
                dsn.setGender(req.getGender());
                dsnRepo.save(dsn);
                response.setStatus("200");
                response.setMessage("Berhasil upload data dosen");
            }else{
                response.setStatus("500");
                response.setMessage("Gagal upload data, sudah ada dosen dengan ID tersebut");
            }
        }catch(Exception e){
            response.setStatus("500");
            response.setMessage("Gagal upload data");
            logger.severe(e.toString());
        }
        return response;
    }

    @Override
    public DosenRes getAllDosen() {
        DosenRes response = new DosenRes();
        try {
            List<Dosen> dsn = dsnRepo.findAll();
            List<DosenDTO> req = new ArrayList<>();
            for(Dosen d: dsn){
                DosenDTO da = new DosenDTO();
                da.setNid(d.getNid());
                da.setNama(d.getNama());
                da.setGender(d.getGender());
                da.setAddres(d.getAddres());
                req.add(da);
            }
            response.setDosenList(req);
            response.setStatus("200");
            response.setMessage("Berhasil mengambil data");

        } catch (Exception e) {
            response.setStatus("500");
            response.setMessage("Gagal mengambil data");
            logger.severe(e.toString());
        }
        return response;
    }

    @Override
    public DosenRes getAllDosenByGender(String gender) {
        DosenRes response = new DosenRes();
        try {
            List<Dosen> dsn = dsnRepo.getAllDosenByGender(gender);
            if(!dsn.isEmpty()){
                List<DosenDTO> req = new ArrayList<>();
                for(Dosen d: dsn){
                    DosenDTO da = new DosenDTO();
                    da.setNid(d.getNid());
                    da.setNama(d.getNama());
                    da.setGender(d.getGender());
                    da.setAddres(d.getAddres());
                    req.add(da);
                }
                response.setDosenList(req);
                response.setStatus("200");
                response.setMessage("Berhasil mengambil data");
            }else{
                response.setStatus("404");
                response.setMessage("Data tidak ditemukan");
            }
        } catch (Exception e) {
            response.setMessage("Gagal mengambil data");
            response.setStatus("500");
            logger.severe(e.toString());
        }
        return response;
    }

    @Override
    public DosenRes getDosenById(String nid) {
        DosenRes response = new DosenRes();
        try{
            Optional<Dosen> req = dsnRepo.findById(nid);
            if (req.isPresent()) {
                Dosen dsn = req.get();
                DosenDTO ddto = new DosenDTO();
                List<DosenDTO> list = new ArrayList<>();
                ddto.setNid(dsn.getNid());
                ddto.setNama(dsn.getNama());
                ddto.setGender(dsn.getGender());
                ddto.setAddres(dsn.getAddres());
                response.setStatus("200");
                response.setMessage("Berhasil");
                list.add(ddto);
                response.setDosenList(list);
            }else{
                response.setStatus("404");
                response.setMessage("data tidak ditemukan");
            }
        }catch(Exception e){
            response.setStatus("500");
            response.setMessage("Gagal");
            logger.severe(e.toString());
        }
        return response;
    }

    @Override
    public DosenRes updateDosen(DosenReq req) {
        DosenRes response = new DosenRes();
        try {
            Optional<Dosen> dosen = dsnRepo.findById(req.getNid());
            if(dosen.isPresent()){
                Dosen dsn = dosen.get();
                dsn.setNid(req.getNid());
                dsn.setNama(req.getNama());
                dsn.setAddres(req.getAddres());
                dsn.setGender(req.getGender());
                dsnRepo.save(dsn);
                response.setStatus("200");
                response.setMessage("Berhasil");
            }else{
                response.setStatus("404");
                response.setMessage("Gagal, dosen tidak ada");
            }
        } catch (Exception e) {
            response.setStatus("500");
            response.setMessage("Gagal");
            logger.severe(e.toString());
        }
        return response;
    }

    @Override
    public DosenRes deleteDosen(DosenReq req) {
        DosenRes response = new DosenRes();
        try {
            Optional<Dosen> dosen = dsnRepo.findById(req.getNid());
            if(dosen.isPresent()){
                dsnRepo.deleteById(req.getNid());
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
