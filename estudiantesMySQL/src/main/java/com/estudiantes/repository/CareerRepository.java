package com.estudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudiantes.model.Career;
@Repository
public interface CareerRepository extends JpaRepository<Career, Long>{

}
