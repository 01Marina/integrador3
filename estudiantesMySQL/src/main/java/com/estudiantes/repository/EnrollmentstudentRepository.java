package com.estudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudiantes.model.Enrollmentstudent;
@Repository
public interface EnrollmentstudentRepository extends JpaRepository<Enrollmentstudent, Long>{

}
