package com.latihan.kampus.service;

import com.latihan.kampus.dto.MahasiswaReq;
import com.latihan.kampus.dto.MahasiswaRes;

public interface  MhsService {
    //void createMahasiswa(Mahasiswa data);
    public MahasiswaRes createMahasiswa(MahasiswaReq req);

    //List<MahasiswaRes> getAllMahasiswa();
    public MahasiswaRes getAllMahasiswa();

    //List<MahasiswaRes> getAllMahasiswaByGender(String gender);
    public MahasiswaRes getAllMahasiswaByGender(MahasiswaReq req);

    //Mahasiswa getMahasiswaByNim(String nim);
    public MahasiswaRes getMahasiswaByNim(MahasiswaReq req);

    //void updateMahasiswa(Mahasiswa data);
    public MahasiswaRes updateMahasiswa(MahasiswaReq req);

    //void deleteMahasiswa(String nim);
    public MahasiswaRes deleteMahasiswa(MahasiswaReq req);


}
