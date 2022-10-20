package com.estudiantes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudiantes.dto.DTOEnrollmentstudentBodyInsert;
import com.estudiantes.model.Career;
import com.estudiantes.model.Enrollmentstudent;
import com.estudiantes.model.Student;
import com.estudiantes.service.CareerService;
import com.estudiantes.service.EnrollmentstudentService;
import com.estudiantes.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/enrollmentstudents")
@Api(value = "EnrollmentstudentController")
public class EnrollmentstudentController {
	
	@Autowired
    private EnrollmentstudentService enrollmentstudentService; //inyecta la dependencia
	
	@Autowired
    private StudentService studentService; //inyecta la dependencia
	
	@Autowired
    private CareerService careerService; //inyecta la dependencia
    
   
	 //2 b) matricular un estudiante en una carrera
    @PostMapping("/insert")
    public ResponseEntity<Enrollmentstudent> newEnrollmentstudent(@Valid @RequestBody DTOEnrollmentstudentBodyInsert e) {
    	if(enrollmentstudentService.existEnrollmentstudent(e)) {
    		return new ResponseEntity<>(HttpStatus.CONFLICT);
    	}
    	System.out.println(e);
    	//Busco el estudiante al que apunta
    	Student student = studentService.findById(e.getId_estudiante()).get();
    	//Busco la carrera a la que apunta
    	Career career = careerService.findById(e.getId_carrera()).get();
    	//creo la matricula
    	Enrollmentstudent saveE;
    	if(e.getFecha_egreso() != null) {
    		saveE = new Enrollmentstudent(student, career, e.getFecha_ingreso(), e.getFecha_egreso() );
    	}else {
    		saveE = new Enrollmentstudent(student, career, e.getFecha_ingreso());
    	}
    	return new ResponseEntity<>(enrollmentstudentService.save(saveE), HttpStatus.CONFLICT);
    }
    /*/*Estructura de JSON para insertar una matricula
     * id autogenerado
     * {
		    "id_estudiante": 1,
		    "id_carrera": 2,
		    "fecha_ingreso": 2012,
		    "fecha_egreso": 2021
		}*/
    
    
    @ApiOperation(value = "Insert Enrollmentstudent ", response = Enrollmentstudent.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!"),
        })
    
    
  //Trae todas las matrticulas
    @GetMapping("/")
    public Iterable<Enrollmentstudent> getEnrollmentstudent() {
        return enrollmentstudentService.findAll();
    }
}
