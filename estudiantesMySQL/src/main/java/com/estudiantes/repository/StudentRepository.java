package com.estudiantes.repository;

import com.estudiantes.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//
//    @Query("SELECT s FROM Student s where t.surname = :surname")
//    public List<Student> findAllBySurname(String surname);
//
//    @Query("SELECT t FROM Person t where t.name = :name")
//    public List<Student> findAllByName(String name);
	
	
//	 @Query("SELECT s FROM Students s")
//		public List<Student> findAll();
	
    
    @Query("SELECT e FROM Student e WHERE e.libreta_universitaria = :bookNumber")
	public Student getStudentByBookNumber(Long bookNumber);
    
    @Query("SELECT s FROM Student s ORDER BY s.nombre ASC")
	public Iterable<Student> getStudentsByOrder();
    
    @Query("SELECT s FROM Student s WHERE s.genero = :gender")
	public Iterable<Student> getStudentsByGender(String gender);
    
    @Query("SELECT s FROM Student s JOIN s.matriculas m JOIN m.carrera c WHERE c.nombre = :career AND s.ciudad_de_residencia = :city ")
    public Iterable<Student> getStudentsByCareerAndCity(String career, String city);
}
