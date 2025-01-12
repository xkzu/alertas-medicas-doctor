package com.alertasmedicas.app.doctor.repository;

import com.alertasmedicas.app.doctor.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    Doctor findByEmail(String email);
}
