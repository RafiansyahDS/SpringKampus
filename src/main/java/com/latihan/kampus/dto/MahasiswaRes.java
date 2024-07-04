package com.latihan.kampus.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MahasiswaRes {
    private List<MahasiswaDTO> mahasiswaList;
    private String status;
    private String message;

    public List<MahasiswaDTO> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(List<MahasiswaDTO> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
