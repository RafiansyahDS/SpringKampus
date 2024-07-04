package com.latihan.kampus.models;

public class Kelas {
    private String dosen;
    private String matkul;

    public Kelas(String dosen, String matkul){
        this.dosen = dosen;
        this.matkul = matkul;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }
}
