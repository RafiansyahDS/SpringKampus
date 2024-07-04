package com.latihan.kampus.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SemesterRes {
    private List<SemesterDTO> semesterList;
    private String status;
    private String message;

    public List<SemesterDTO> getSemesterList() {
        return semesterList;
    }

    public void setSemesterList(List<SemesterDTO> semesterList) {
        this.semesterList = semesterList;
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
