package com.latihan.kampus.service;


import com.latihan.kampus.dto.DosenReq;
import com.latihan.kampus.dto.DosenRes;

public interface DsnService {
    //void createDosen(Dosen req);
    public DosenRes createDosen(DosenReq req);

    //List<DosenRes> getAllDosen();
    public DosenRes getAllDosen();

    public DosenRes getAllDosenByGender(String gender);

    //Dosen getDosenById(String nid);
    DosenRes getDosenById(String nid);

    //void updateDosen(Dosen req);
    DosenRes updateDosen(DosenReq req);

    //void deleteDosen(String nid);
    DosenRes deleteDosen(DosenReq req);
    
    //List<KelasRes> getKelas();


}
