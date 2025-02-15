package com.alertasmedicas.app.doctor.dto;

public record DoctorDTO(
        Long id,
        String name,
        String speciality,
        String email,
        boolean isAdmin
) {}
