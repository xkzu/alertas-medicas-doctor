package com.alertasmedicas.app.doctor.service;

import com.alertasmedicas.app.doctor.dto.DoctorDTO;
import com.alertasmedicas.app.doctor.entity.Doctor;
import com.alertasmedicas.app.doctor.mapper.DoctorMapper;
import com.alertasmedicas.app.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getDoctors() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<DoctorDTO> getDoctorsAsDTO() {
        return getDoctors()
                .stream()
                .map(DoctorMapper::toDoctorDTO)
                .toList();
    }

    @Override
    public DoctorDTO saveDoctorAsDTO(DoctorDTO doctorDTO) {
        // Convierte el DoctorDTO en una entidad Doctor
        Doctor doctor = DoctorMapper.toDoctor(doctorDTO);

        // Guarda el doctor
        Doctor savedDoctor = saveDoctor(doctor);

        // Convierte el Doctor guardado nuevamente a un DoctorDTO para devolverlo
        return DoctorMapper.toDoctorDTO(savedDoctor);
    }

    @Override
    public DoctorDTO getDoctorAsDTO(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElse(new Doctor());
        return DoctorMapper.toDoctorDTO(doctor);
    }

    @Override
    public void deleteDoctorAsDTO(Long id) {
        doctorRepository.deleteById(id);
    }

}
