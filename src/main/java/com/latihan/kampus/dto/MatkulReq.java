package com.latihan.kampus.dto;

public class MatkulReq {
    private String id;
    private String nama;

    public MatkulReq(String id, String namaMatkul){
        this.id = id;
        this.nama = namaMatkul;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
