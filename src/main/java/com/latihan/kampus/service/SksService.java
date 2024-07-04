package com.latihan.kampus.service;

import javax.servlet.http.HttpServletResponse;

import com.latihan.kampus.dto.KelasRes;
import com.latihan.kampus.dto.MatkulRes;
import com.latihan.kampus.dto.SemesterRes;

public interface SksService {
    public SemesterRes getSemester();
    public KelasRes getKelas();
    public MatkulRes getMatkul();
    
    public void createSemesterReport(HttpServletResponse res);
    public void createKelasReport(HttpServletResponse res);
}
