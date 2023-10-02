package com.microservice.CitizenService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.CitizenService.Entity.Citizen;
import com.microservice.CitizenService.Service.CitizenService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
 private CitizenService cs;
	
	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<>("hello",HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<List<Citizen>> GetCitizenByVaccinationCenterId(@PathVariable Integer id){ // variable type and variable we need to pass inside the method so the value we are passing  through the url will be store based on that it will fetch the data
		return cs.getCitizenByCenterId(id) ;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Citizen> add(@RequestBody   Citizen c){
		return cs.insert(c);
	}
	
}
