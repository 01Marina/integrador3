package com.estudiantes.service;

import com.estudiantes.model.Enrollmentstudent;

public interface EnrollmentstudentService {
	
	public Enrollmentstudent save(Enrollmentstudent e);
	
	public Iterable<Enrollmentstudent> findAll();
}
