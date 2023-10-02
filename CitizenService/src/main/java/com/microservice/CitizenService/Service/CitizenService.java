package com.microservice.CitizenService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.CitizenService.Entity.Citizen;
import com.microservice.CitizenService.Repository.CitizenRepo;

@Service
public class CitizenService {
	@Autowired
 private CitizenRepo cr;
	
	public ResponseEntity<List<Citizen>> getCitizenByCenterId(Integer id) {
		
		return  new ResponseEntity<> (cr.findByVaccinationCenterId(id),HttpStatus.OK);
	}

	public ResponseEntity<Citizen> insert(Citizen c) {
		Citizen n = cr.save(c);
		return new ResponseEntity<>(n,HttpStatus.ACCEPTED);
		
	}

	
}
