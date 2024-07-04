package com.latihan.kampus.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latihan.kampus.dto.KelasDTO;
import com.latihan.kampus.dto.KelasRes;
import com.latihan.kampus.dto.MatkulDTO;
import com.latihan.kampus.dto.MatkulRes;
import com.latihan.kampus.dto.SemesterDTO;
import com.latihan.kampus.dto.SemesterRes;
import com.latihan.kampus.models.Kelas;
import com.latihan.kampus.models.Matkul;
import com.latihan.kampus.models.Semester;
import com.latihan.kampus.repository.KelasRepo;
import com.latihan.kampus.repository.MatkulRepo;
import com.latihan.kampus.repository.SksRepo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class SksServiceImpl implements SksService {

    private static final Logger logger = Logger.getLogger(SksServiceImpl.class.getName());

    @Autowired
    private SksRepo sksRepo;

    @Autowired
    private MatkulRepo mklRepo;

    @Autowired
    private KelasRepo klsRepo;

    @Override
    public SemesterRes getSemester() {
        SemesterRes response = new SemesterRes();
            try {
                List<Semester> sems = sksRepo.getSemester();
                List<SemesterDTO> data = new ArrayList<>();
                for(Semester s: sems){
                    SemesterDTO sr = new SemesterDTO();
                    sr.setNama(s.getNama());
                    sr.setMatkul(s.getMatkul());
                    sr.setNamaDosen(s.getNamaDosen());
                    sr.setNim(s.getNim());
                    data.add(sr);
                }
                response.setSemesterList(data);
                response.setStatus("200");
                response.setMessage("Berhasil");
            } catch (Exception e) {
                response.setStatus("500");
                response.setMessage("Gagal");
                logger.severe(e.toString());
            }
        return response;
    }

     @Override
    public KelasRes getKelas() {
        KelasRes response = new KelasRes();
        try {
            List<Kelas> kelas = klsRepo.getKelas();
            List<KelasDTO> kls = new ArrayList<>();
            for(Kelas k: kelas){
                KelasDTO data = new KelasDTO();
                data.setDosen(k.getDosen());
                data.setMatkul(k.getMatkul());
                kls.add(data);
            }
            response.setKelasList(kls);
            response.setStatus("200");
            response.setMessage("Berhasil");
        } catch (Exception e) {
            response.setStatus("500");
            response.setMessage("Gagal");
            logger.severe(e.toString());
        }
        return response;
    }

    @Override
    public MatkulRes getMatkul() {
        MatkulRes response = new MatkulRes();
        try{
            List<Matkul> matkul = mklRepo.findAll();
            List<MatkulDTO> mkl = new ArrayList<>();
            for(Matkul m: matkul){
                MatkulDTO data = new MatkulDTO();
                data.setNama(m.getNama());
                data.setId(m.getId());
                mkl.add(data);
            }
            response.setMatkulList(mkl);
            response.setStatus("200");
            response.setMessage("Berhasil");
        }catch(Exception e){
            response.setStatus("500");
            response.setMessage("Gagal");
            logger.severe(e.toString());
        }
        return response;
    }

    @Override
    public void createSemesterReport(HttpServletResponse res){
        try {
            List<Semester> semester = sksRepo.getSemester();
            InputStream jasperStream = this.getClass().getResourceAsStream("/reports/Semester.jasper");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("Title", "Laporan Kelas");
            parameters.put("CompanyName", "UNIVERSITAS NEGERI GAIB");

            InputStream imageStream = this.getClass().getResourceAsStream("/images/logo.png");
            BufferedImage image = ImageIO.read(imageStream);
            parameters.put("Logo", image);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(semester);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            res.setContentType("application/pdf");
            res.setContentLength(reportBytes.length);
            res.setHeader("Content-Disposition", "attachment; filename=\"Laporan Semester.pdf\"");
            res.flushBuffer();
            try (OutputStream outputStream = res.getOutputStream()) {
                outputStream.write(reportBytes);
            }
        } catch (JRException | IOException e) {
            logger.severe(e.toString());
        }
    }

    @Override
    public void createKelasReport(HttpServletResponse res){
       try {
            List<Kelas> kls = klsRepo.getKelas();
            InputStream jasperStream = this.getClass().getResourceAsStream("/reports/Kelas.jasper");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("Title", "Laporan Kelas");
            parameters.put("CompanyName", "UNIVERSITAS NEGERI GAIB");

            InputStream imageStream = this.getClass().getResourceAsStream("/images/logo.png");
            BufferedImage image = ImageIO.read(imageStream);
            parameters.put("Logo", image);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(kls);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            res.setContentType("application/pdf");
            res.setContentLength(reportBytes.length);
            res.setHeader("Content-Disposition", "attachment; filename=\"Laporan Kelas.pdf\"");
            res.flushBuffer();
            try (OutputStream outputStream = res.getOutputStream()) {
                outputStream.write(reportBytes);
            }
       } catch (JRException | IOException e) {
        logger.severe(e.toString());
       }
    }
}
