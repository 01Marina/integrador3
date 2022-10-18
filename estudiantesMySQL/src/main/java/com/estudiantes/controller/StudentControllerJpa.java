package com.estudiantes.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.estudiantes.model.Student;
import com.estudiantes.service.StudentService;


@RestController
@RequestMapping("/api/students")
@Api(value = "StudentControllerJpa")
public class StudentControllerJpa {

    @Autowired
    private StudentService studentService; //inyecta la dependencia
    
  //Trae todos los estudiantes
    @GetMapping("/")
    public Iterable<Student> getStudents() {
        return studentService.findAll();
    }
    
    
        @ApiOperation(value = "Get list of persons by surname ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
        
    //2a
    //crea un nuevo estudiante
    @PostMapping("/insert")
    public Student newStudent(@RequestBody Student s) {
        return studentService.save(s);
    }
    /*Estructura de JSON para insertar un estudiante
     * id autogenerado
     * 
     * {
	     	"nombre": "Juan",
	        "edad": 34,
	        "genero": "m",
	        "dni": 3454543,
	        "ciudad_de_residencia": "Balcarce",
	        "libreta_universitaria": 76564,
	        "matriculas": []
        }
     * */
        
    //2c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
    //TESTEADO EN POSTMAN
    @GetMapping("/sortedbyname")
    public Iterable<Student> getStudentsByOrder() {
    	return studentService.getStudentsByOrder();
    }
    
    //2d) recuperar un estudiante, en base a su número de libreta universitaria.
    //TESTEADO EN POSTMAN
    @GetMapping("/bookNumber/{bookNumber}")
    public Student getStudentByBookNumber(@PathVariable Integer bookNumber) {
    	return studentService.getStudentByBookNumber(bookNumber);
    }
  
    //2e) recuperar todos los estudiantes, en base a su género.
    //TESTEADO EN POSTMAN
    @GetMapping("/gender/{gender}")
    public Iterable<Student> getStudentsByGender(@PathVariable String gender) {
    	return studentService.getStudentsByGender(gender);
    }
    

    //2g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
    //NO ESTÁ TESTEADA
    @GetMapping("/{career}/{city}")
    public Iterable<Student> getStudentsByCareerAndCity(@PathVariable String career, @PathVariable String city) {
    	return studentService.getStudentsByCareerAndCity(career, city);
    }
}

