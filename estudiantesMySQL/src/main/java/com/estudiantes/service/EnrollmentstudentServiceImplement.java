package com.estudiantes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudiantes.model.Enrollmentstudent;
import com.estudiantes.repository.EnrollmentstudentRepository;
@Service
public class EnrollmentstudentServiceImplement implements EnrollmentstudentService{
	
	@Autowired
	private EnrollmentstudentRepository enrollmentstudentRepository;//inyecta la dependencia

	@Override
	public Enrollmentstudent save(Enrollmentstudent e) {
		return enrollmentstudentRepository.save(e);
	}

	@Override
	public Iterable<Enrollmentstudent> findAll() {
		return enrollmentstudentRepository.findAll();
	}

}
