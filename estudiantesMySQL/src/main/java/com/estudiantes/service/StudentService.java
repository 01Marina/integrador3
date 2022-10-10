package com.estudiantes.service;

import com.estudiantes.model.Student;

public interface StudentService {
	
	public Student save(Student s);
	
	public Iterable<Student> findAll();

	public Student getStudentByBookNumber(Long bookNumber);

	public Iterable<Student> getStudentsByOrder();

	public Iterable<Student> getStudentsByGender(String gender);

	public Iterable<Student> getStudentsByCareerAndCity(String career, String city);
}
