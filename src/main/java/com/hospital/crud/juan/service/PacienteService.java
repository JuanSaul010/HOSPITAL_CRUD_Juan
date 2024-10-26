package com.hospital.crud.juan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.crud.juan.entity.Paciente;
import com.hospital.crud.juan.repository.PacienteRepository;

@Service
public class PacienteService {
	 
	@Autowired
	private PacienteRepository repo;
	
	public List<Paciente> listarPaciente(){
		return repo.findAll();
	}
	
	public void grabarPaciente(Paciente obj) {
		repo.save(obj);
	}
	public void eliminarPaciente(Integer cod){
		repo.deleteById(cod);
	}
	public Paciente buscarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	
}
