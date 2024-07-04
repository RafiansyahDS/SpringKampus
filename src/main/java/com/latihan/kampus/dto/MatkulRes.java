package com.latihan.kampus.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MatkulRes {
    private List<MatkulDTO> matkulList;
    private String status;
    private String message;

    public List<MatkulDTO> getMatkulList() {
        return matkulList;
    }

    public void setMatkulList(List<MatkulDTO> matkulList) {
        this.matkulList = matkulList;
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
