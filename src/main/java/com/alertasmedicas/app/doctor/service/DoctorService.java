package com.alertasmedicas.app.doctor.service;

import com.alertasmedicas.app.doctor.dto.DoctorDTO;
import com.alertasmedicas.app.doctor.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<Doctor> getDoctors();

    Optional<Doctor> getDoctorById(Long id);

    Doctor saveDoctor(Doctor doctor);

    Doctor updateDoctor(Doctor doctor);

    void deleteDoctor(Long id);

    List<DoctorDTO> getDoctorsAsDTO();

    DoctorDTO saveDoctorAsDTO(DoctorDTO doctorDTO);

    DoctorDTO getDoctorAsDTO(String email);

    void deleteDoctorAsDTO(Long id);
}
