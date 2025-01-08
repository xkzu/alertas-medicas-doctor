package com.alertasmedicas.app.doctor.controller;

import com.alertasmedicas.app.doctor.dto.DoctorDTO;
import com.alertasmedicas.app.doctor.service.DoctorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/getDoctors")
    public ResponseEntity<List<DoctorDTO>> getDoctors() {
        log.info("Obteniendo lista de doctores...");
        try {
            List<DoctorDTO> doctors = doctorService.getDoctorsAsDTO();
            log.info("Lista de doctores obtenida exitosamente. Total: {} doctores.", doctors.size());
            return ResponseEntity.ok(doctors);
        } catch (Exception e) {
            log.error("Error al obtener la lista de doctores: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getDoctor/{id}")
    public ResponseEntity<DoctorDTO> getDoctor(@PathVariable Long id) {
        log.info("Obteniendo doctor con id: {}", id);
        try {
            DoctorDTO dto = doctorService.getDoctorAsDTO(id);
            log.info("Doctor obtenido exitosamente: {}", dto);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            log.error("Error al obtener un doctor: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<DoctorDTO> addDoctor(@RequestBody DoctorDTO doctorDTO) {
        log.info("Agregando doctor...");
        try {
            log.info("Datos del doctor: {}", doctorDTO);
            DoctorDTO dto = doctorService.saveDoctorAsDTO(doctorDTO);
            log.info("Doctor agregado exitosamente");
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            log.error("Error al guardar el doctor: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DoctorDTO> deleteDoctor(@PathVariable Long id) {
        log.info("Eliminando doctor con id: {}", id);
        try {
            doctorService.deleteDoctorAsDTO(id);
            log.info("Doctor eliminado exitosamente");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Error al eliminar el doctor: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

}
