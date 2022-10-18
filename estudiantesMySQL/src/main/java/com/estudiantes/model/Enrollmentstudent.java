package com.estudiantes.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Enrollmentstudent{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_matricula;
	@Column
	private int fecha_ingreso;
	
	@Column (nullable = true)
	private Integer fecha_egreso;
	
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	@JoinColumn(name ="id_estudiante", referencedColumnName = "id_estudiante")
	@JsonProperty(access = Access.WRITE_ONLY)//para que en la api ignore la propiedad para serilizar la cadena
	private Student estudiante;
	
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	@JoinColumn(name="id_carrera", referencedColumnName = "id_carrera")
	@JsonProperty(access = Access.WRITE_ONLY)//para que en la api ignore la propiedad para serilizar la cadena
	private Career carrera;
	
	public Enrollmentstudent() {
		super();
	}

	public Enrollmentstudent(Student estudiante, Career carrera, int fechaIngreso) {
		super();
		this.carrera = carrera;
		this.fecha_ingreso = fechaIngreso;
		this.estudiante = estudiante;
	}
	
	public Enrollmentstudent(Student estudiante, Career carrera, int fechaIngreso, int fechaEgreso) {
		super();
		this.carrera = carrera;
		this.fecha_ingreso = fechaIngreso;
		this.fecha_egreso = fechaEgreso;
		this.estudiante = estudiante;
	}

	@Override
	public String toString() {
		return " [estudiante= "+ estudiante +"carrera=" + carrera + ", fechaIngreso=" + fecha_ingreso +"]";
	}

	public int getFechaIngreso() {
		return fecha_ingreso;
	}

	public void setFechaIngreso(int fechaIngreso) {
		this.fecha_ingreso = fechaIngreso;
	}

	public Student getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Student estudiante) {
		this.estudiante = estudiante;
	}

	public Career getCarrera() {
		return carrera;
	}

	public void setCarrera(Career carrera) {
		this.carrera = carrera;
	}

	public int getIdMatricula() {
		return id_matricula;
	}

	public Integer getFechaEgreso() {
		return fecha_egreso;
	}

	public void setFechaEgreso(Integer fechaEgreso) {
		this.fecha_egreso = fechaEgreso;
	}
	
}
