package com.vaccinCenter.VaccinationCenter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vaccinCenter.VaccinationCenter.Entity.VaccinationCenter;
import com.vaccinCenter.VaccinationCenter.Model.RequiredResponse;
import com.vaccinCenter.VaccinationCenter.Repo.VaccinationCenterRepo;
import com.vaccinCenter.VaccinationCenter.Service.VaccinationCenterService;

@RestController
@RequestMapping("vc")
public class VaccinationCenterController {
	@Autowired
	VaccinationCenterService vs;
	
	@Autowired
	VaccinationCenterRepo ve;

	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> add(@RequestBody VaccinationCenter vaccin){
		return vs.insert(vaccin);
	}
	
	@GetMapping("/id/{id}")
	@HystrixCommand(fallbackMethod = "handleCitizenDownTime")
	public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable Integer id){
		return vs.getAllDataBasedOnCenterId(id);
	}
	
	public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Integer id){
	
		      RequiredResponse rr = new RequiredResponse();
				VaccinationCenter center = ve.findById(id).get();
				rr.setCenter(center);
				return new ResponseEntity<RequiredResponse>(rr,HttpStatus.OK);
			
		
	}
}
