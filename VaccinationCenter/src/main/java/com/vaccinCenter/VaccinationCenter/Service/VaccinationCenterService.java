package com.vaccinCenter.VaccinationCenter.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vaccinCenter.VaccinationCenter.Entity.VaccinationCenter;
import com.vaccinCenter.VaccinationCenter.Model.Citizen;
import com.vaccinCenter.VaccinationCenter.Model.RequiredResponse;
import com.vaccinCenter.VaccinationCenter.Repo.VaccinationCenterRepo;

@Service
public class VaccinationCenterService {
	@Autowired
	VaccinationCenterRepo ve;
	
	@Autowired
	private RestTemplate rt;

	public ResponseEntity<VaccinationCenter> insert(VaccinationCenter vaccin) {
		VaccinationCenter s = ve.save(vaccin);
		return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(Integer id) {
		RequiredResponse rr = new RequiredResponse();
		
		//first get all center details
		VaccinationCenter center = ve.findById(id).get();
		rr.setCenter(center);
		
		//get all citizens details Registered to a center
		//List<Citizen> list =rt.getForObject("http://localhost:8093/citizen/id/"+id, List.class); here we are using the localhost with port 8095 while calling this url 8093 again it will internally call 8095
		List<Citizen> list =rt.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);// here we can use citizen-service in behalf of localhost 8095
		rr.setCitizens(list);
		return new ResponseEntity<RequiredResponse>(rr,HttpStatus.OK);
	}

	
	

}
