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
import com.hospital.crud.juan.service.HospitalService;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
     
	@Autowired
	private HospitalService servicioHospital;
	
	@GetMapping("/lista")
	public String inicioLista(Model model) {
		List<Hospital> dataHos = servicioHospital.listarHospital();
		model.addAttribute("hospitales",dataHos);
		return "ListarHospital";	
	}
	
	@GetMapping("/formRegistrarHospital")
	public String inicioRegistrarHospital(Model model) {
		Hospital hospital = new Hospital();
		model.addAttribute("registroHospital",hospital);
		return "RegistrarHospital";
	}
	
	@PostMapping("/registrarHospital")
	public String registrarHospital(@ModelAttribute Hospital hos,Model model) {	
		servicioHospital.grabarHospital(hos);
		System.out.println("datos registrados en bd");
		return "redirect:/hospital/lista";
	}
	
	@GetMapping("editarHospital/{id}")
	public String editar(@PathVariable("id") Integer id, Model model) {
		Hospital hos = servicioHospital.buscarPorId(id);
		model.addAttribute("registroHospital", hos);
		return "RegistrarHospital";
	}
	
	@GetMapping("eliminarHospital/{id}")
	public String eliminar (@PathVariable("id") Integer id, Model model) {
		servicioHospital.eliminarHospital(id);
		List<Hospital> dataHos = servicioHospital.listarHospital();
		model.addAttribute("hospitales",dataHos);
		return "redirect:/hospital/lista";
		
	}
	
	
} 