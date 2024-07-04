package com.latihan.kampus.dto;

public class SemesterReq {
    private String matkul;
    private String namaDosen;
    private String nama; 
    private String nim;

    public SemesterReq(String nim, String nama, String matkul, String namaDosen){
        this.nama = nama;
        this.nim = nim;
        this.matkul = matkul;
        this.namaDosen = namaDosen;
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

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }
}
