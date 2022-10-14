package com.estudiantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudiantes.model.Career;
import com.estudiantes.service.CareerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/careers")
@Api(value = "CareerController")
public class CareerController {
	
	@Autowired
    private CareerService careerService; //inyecta la dependencia
	

    @ApiOperation(value = "Get list of persons by surname ", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "not authorized!"),
        @ApiResponse(code = 403, message = "forbidden!!!"),
        @ApiResponse(code = 404, message = "not found!!!") })
    
    @PostMapping("/insert")
    public Career newCareer(@RequestBody Career c) {
        return careerService.save(c);
    }
    /*/*Estructura de JSON para insertar una carrera
     * id autogenerado
     * {
		    "nombre": null
	    }
     * */
    
  //Trae todas las carreras
    @GetMapping("/")
    public Iterable<Career> getCareers() {
        return careerService.findAll();
    }
}
