package com.latihan.kampus.dto;

public class MahasiswaReq {
    private String nim;
    private String nama;
    private String gender;
    private String addres;

    public MahasiswaReq(String nim, String nama, String gender, String address){
        this.nama = nama;
        this.nim = nim;
        this.gender = gender;
        this.addres = address;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
    
}
