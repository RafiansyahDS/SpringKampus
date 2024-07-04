package com.latihan.kampus.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Dosmat {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name="nid", referencedColumnName="nid")
    private Dosen dosen;

    @ManyToOne
    @JoinColumn(name="idmk", referencedColumnName="id")
    private Matkul matkul;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public Matkul getMatkul() {
        return matkul;
    }

    public void setMatkul(Matkul matkul) {
        this.matkul = matkul;
    }
}
