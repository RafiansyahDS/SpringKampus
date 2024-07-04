package com.latihan.kampus.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class KelasRes {
    private List<KelasDTO> kelasList;
    private String status;
    private String message;

    public List<KelasDTO> getKelasList() {
        return kelasList;
    }

    public void setKelasList(List<KelasDTO> kelasList) {
        this.kelasList = kelasList;
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
