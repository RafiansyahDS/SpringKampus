package com.latihan.kampus.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DosenRes {
    private List<DosenDTO> dosenList;
    private String status;
    private String message;

    public List<DosenDTO> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<DosenDTO> dosenList) {
        this.dosenList = dosenList;
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
