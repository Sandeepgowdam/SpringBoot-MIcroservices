package com.vaccinCenter.VaccinationCenter.Model;

import java.util.List;

import com.vaccinCenter.VaccinationCenter.Entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequiredResponse {
// this is the Pojo class to handle both vaccinationCenter and Citizen
	
	
	private VaccinationCenter center;
	private List<Citizen> citizens;
}

// this is pojo returned from the contoller