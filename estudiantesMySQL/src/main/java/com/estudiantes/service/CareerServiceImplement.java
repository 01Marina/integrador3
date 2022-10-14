package com.estudiantes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudiantes.model.Career;
import com.estudiantes.repository.CareerRepository;

@Service
public class CareerServiceImplement implements CareerService{
	
	@Autowired
	private CareerRepository careerRepository;//inyecta la dependencia

	@Override
	public Career save(Career c) {
		return careerRepository.save(c);
	}

	@Override
	public Iterable<Career> findAll() {
		return careerRepository.findAll();
	}

}
