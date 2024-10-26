package com.hospital.crud.juan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.crud.juan.entity.Hospital;
import com.hospital.crud.juan.repository.HospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepository repo;
	
	public List<Hospital>listarHospital(){
		return repo.findAll();
	}
	
	public void grabarHospital(Hospital obj) {
		repo.save(obj);
	}
	
	public void eliminarHospital(Integer cod) {
		repo.deleteById(cod);	
	}
	
	public Hospital buscarPorId(Integer id) {
		return repo.findById(id).orElse(null);
	}

}
