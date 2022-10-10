package com.estudiantes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Career {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_carrera;
	@Column
	private String nombre;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "carrera", cascade=CascadeType.ALL)
	private List<Enrollmentstudent> matriculas;
	
	public Career() {
		super();
		this.matriculas = new ArrayList<>();
	}
	public Career(String nombre) {
		super();
		this.nombre = nombre;
		this.matriculas = new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id_carrera;
	}
	@Override
	public String toString() {
		return "Carrera [idCarrera=" + id_carrera + ", nombre=" + nombre + "]";
	}
	
	
	
}
