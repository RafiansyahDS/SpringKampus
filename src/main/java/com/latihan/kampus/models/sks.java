package com.latihan.kampus.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class sks {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name= "nim", referencedColumnName= "nim")
    private Mahasiswa mahasiswa;

    @ManyToOne
    @JoinColumn(name="idkel", referencedColumnName = "id")
    private Dosmat dosmat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public Dosmat getDosmat() {
        return dosmat;
    }

    public void setDosmat(Dosmat dosmat) {
        this.dosmat = dosmat;
    }
}
