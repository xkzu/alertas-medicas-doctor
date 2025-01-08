package com.alertasmedicas.app.doctor.mapper;

import com.alertasmedicas.app.doctor.dto.DoctorDTO;
import com.alertasmedicas.app.doctor.entity.Doctor;

public class DoctorMapper {

    private DoctorMapper() {}

    public static DoctorDTO toDoctorDTO(Doctor doctor) {
        return new DoctorDTO(
                doctor.getId(),
                doctor.getName(),
                doctor.getSpeciality(),
                doctor.getEmail(),
                doctor.getPassword(),
                doctor.isAdmin()
        );
    }

    public static Doctor toDoctor(DoctorDTO dto) {
        return new Doctor(
                dto.id(), // no utilizamos get debido a que Doctor es un record no un TO, de esta forma evitamos la redundancia
                dto.name(),
                dto.speciality(),
                dto.email(),
                dto.password(),
                dto.isAdmin()
        );
    }
}
