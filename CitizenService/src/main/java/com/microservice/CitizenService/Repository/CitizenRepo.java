package com.microservice.CitizenService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservice.CitizenService.Entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {

     List<Citizen> findByVaccinationCenterId(Integer id);
     
     // here we are supposed to write code when we need to get any data based on non primary key data 
     // here Jpa only look at and obtain data based on attribute type and method with findBy and name of the attribute
     // for primary key data we cannot write we write directly in service where there certain in built methods

}
