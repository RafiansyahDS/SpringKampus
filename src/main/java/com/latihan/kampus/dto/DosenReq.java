package com.latihan.kampus.dto;

public class DosenReq {
    private String nid;
    private String nama;
    private String gender;
    private String addres;

    public DosenReq(String nid, String nama, String gender, String address){
        this.nama = nama;
        this.nid = nid;
        this.gender = gender;
        this.addres = address;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
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
