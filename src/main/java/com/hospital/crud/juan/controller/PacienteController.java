package com.hospital.crud.juan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.crud.juan.entity.Hospital;
import com.hospital.crud.juan.entity.Paciente;
import com.hospital.crud.juan.service.HospitalService;
import com.hospital.crud.juan.service.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	private PacienteService serviciopaciente;
	@Autowired 
	private HospitalService serviciohospital;
	
	
	@GetMapping("/lista")
	public String  inicioLista (Model model) {
		List<Paciente> dataPac =serviciopaciente.listarPaciente();
		model.addAttribute("pacientes",dataPac);
		return "ListarPaciente";
	}
	
	@GetMapping("/formRegistrarPaciente")
	public String inicioRegistrarPaciente (Model model) {
		Paciente paciente = new Paciente();
		List<Hospital> dataHos = serviciohospital.listarHospital();
		model.addAttribute("registroPaciente",paciente);
		model.addAttribute("hospitales",dataHos);
		return "RegistrarPaciente";
	}
	
	@PostMapping("/registrarPaciente")
	public String registrarPaciente(@ModelAttribute Paciente paciente,Model model) {
		serviciopaciente.grabarPaciente(paciente);
		System.out.println("Paciente Registrado en la bd");
		return "redirect:/paciente/lista";
	}
	
	@GetMapping("/editarPaciente/{id}")
	public String editarPaciente (@PathVariable("id") Integer id,Model model) {
		Paciente paciente = serviciopaciente.buscarPorId(id);
		List<Hospital> dataHos = serviciohospital.listarHospital();
		model.addAttribute("registroPaciente",paciente);
		model.addAttribute("hospitales",dataHos);
		return "RegistrarPaciente";
	}
	
	
	@GetMapping("/eliminarPaciente/{id}")
	public String eliminarPaciente (@PathVariable("id") Integer id,Model model) {
		serviciopaciente.eliminarPaciente(id);
		List<Paciente> dataPac =  serviciopaciente.listarPaciente();
		model.addAttribute("pacientes",dataPac);
		return "redirect:/paciente/lista";
	}
	
	
	
	

}
