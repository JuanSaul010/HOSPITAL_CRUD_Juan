package com.hospital.crud.juan.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_hospital")
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hospital")
	private Integer id;
	@Column(name = "nombre_hospital")
	private String nombre_hos;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "capacidad")
	private int capacidad;
    @Column(name = "fecha_creacion")
    private LocalDate fecha_creacion;
    
    @OneToMany(mappedBy="hospital")
    private Set<Paciente> listaPacientes = new HashSet<>();

	public Hospital(Integer id, String nombre_hos, String direccion, String telefono, int capacidad,
			LocalDate fecha_creacion, Set<Paciente> listaPacientes) {
		super();
		this.id = id;
		this.nombre_hos = nombre_hos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.capacidad = capacidad;
		this.fecha_creacion = fecha_creacion;
		this.listaPacientes = listaPacientes;
	}

	public Hospital() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre_hos() {
		return nombre_hos;
	}

	public void setNombre_hos(String nombre_hos) {
		this.nombre_hos = nombre_hos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Set<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(Set<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}
    
    
    
    
    
}
