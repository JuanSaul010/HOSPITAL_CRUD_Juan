package com.hospital.crud.juan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.crud.juan.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
