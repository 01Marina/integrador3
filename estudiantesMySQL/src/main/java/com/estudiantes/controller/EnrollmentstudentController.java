package com.estudiantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudiantes.model.Enrollmentstudent;
import com.estudiantes.service.EnrollmentstudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/enrollmentstudents")
@Api(value = "EnrollmentstudentController")
public class EnrollmentstudentController {
	
	@Autowired
    private EnrollmentstudentService enrollmentstudentService; //inyecta la dependencia
	

    @ApiOperation(value = "Get list of persons by surname ", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    
    @PostMapping("/insert")
    public Enrollmentstudent newEnrollmentstudent(@RequestBody Enrollmentstudent e) {
        return enrollmentstudentService.save(e);
    }
    
    /*/*Estructura de JSON para insertar una matricula
     * id autogenerado
     * {
		    "estudiante": 1,
		    "carrera": 2,
		    "fechaIngreso": 2022,
		    "fechaEgreso": null
		}*/
    
  //Trae todas las matrticulas
    @GetMapping("/")
    public Iterable<Enrollmentstudent> getEnrollmentstudent() {
        return enrollmentstudentService.findAll();
    }
}
