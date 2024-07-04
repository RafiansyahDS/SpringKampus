# Spring Kampus API Documentation

Welcome to the Spring Kampus API documentation. This project manages various aspects of a campus environment using Spring Framework, integrating JasperReports for report generation, and following the MVC (Model-View-Controller) architectural pattern.

## Mahasiswa (Student)

### Retrieve All Mahasiswa
- **GET**: `/api/mahasiswa`
  - Retrieves a list of all Mahasiswa (students).

### Create Mahasiswa
- **POST**: `/api/mahasiswa/upload`
  - Creates a new Mahasiswa (student).
  - **Request Body** (JSON):
    ```json
    {
      "nim": "12321",
      "nama": "TESTINGMHS",
      "gender": "LAKI-LAKI",
      "addres": "JL. TESTING"
    }
    ```

### Update Mahasiswa
- **PATCH**: `/api/mahasiswa/update`
  - Updates an existing Mahasiswa (student).
  - **Request Body** (JSON):
    ```json
    {
      "nim": "12321",
      "nama": "MHSTESTING",
      "gender": "LAKI-LAKI",
      "addres": "JL. TESTING"
    }
    ```

### Delete Mahasiswa
- **DELETE**: `/api/mahasiswa/delete`
  - Deletes a Mahasiswa (student) by NIM (student ID).
  - **Request Body** (JSON):
    ```json
    {
      "nim": "12321"
    }
    ```

## Sks (Credits)

### Retrieve All Kelas (Classes)
- **GET**: `/api/kelas`
  - Retrieves a list of all Kelas (classes).

### Retrieve All Semesters
- **GET**: `/api/semester`
  - Retrieves a list of all Semesters.

### Retrieve All Mata Kuliah (Courses)
- **GET**: `/api/matkul`
  - Retrieves a list of all Mata Kuliah (courses).

## Dosen (Lecturer)

### Retrieve All Dosen (Lecturers)
- **GET**: `/api/dosen`
  - Retrieves a list of all Dosen (lecturers).

### Create Dosen
- **POST**: `/api/dosen/upload`
  - Creates a new Dosen (lecturer).
  - **Request Body** (JSON):
    ```json
    {
      "nid": "12321",
      "nama": "TESTINGDSN",
      "gender": "LAKI-LAKI",
      "addres": "JL. TESTING"
    }
    ```

### Update Dosen
- **PATCH**: `/api/dosen/update`
  - Updates an existing Dosen (lecturer).
  - **Request Body** (JSON):
    ```json
    {
      "nid": "12321",
      "nama": "DSNTESTING",
      "gender": "LAKI-LAKI",
      "addres": "JL. TESTING"
    }
    ```

### Delete Dosen
- **DELETE**: `/api/dosen/delete`
  - Deletes a Dosen (lecturer) by NID (lecturer ID).
  - **Request Body** (JSON):
    ```json
    {
      "nid": "12321"
    }
    ```

## Reporting

### Generate Semester Report
- **GET**: `/api/semester/create-report`
  - Generates a report for the semester using JasperReports.

### Generate Kelas Report
- **GET**: `/api/kelas/create-report`
  - Generates a report for classes using JasperReports.

## Getting Started

### Prerequisites
- Maven
- Java 8 or higher
- Spring Boot (this project use Spring v2.7.18 to be able work with java 8) 
- JasperReports
