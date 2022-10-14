package com.estudiantes.service;

import com.estudiantes.model.Career;

public interface CareerService {
	
	public Career save(Career c);
	
	public Iterable<Career> findAll();
}
