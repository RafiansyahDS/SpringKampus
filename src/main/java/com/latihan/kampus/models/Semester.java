package com.latihan.kampus.models;

public class Semester {
    private String matkul;
    private String namaDosen;
    private String nama; 
    private String nim;
    

    public Semester(String nim, String nama, String matkul, String namaDosen){
        this.matkul = matkul;
        this.namaDosen = namaDosen;
        this.nama = nama;
        this.nim = nim;
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
