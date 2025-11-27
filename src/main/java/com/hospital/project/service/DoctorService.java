package com.hospital.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hospital.project.ResponseStructure;
import com.hospital.project.entity.Doctor;
import com.hospital.project.repository.DoctorRepo;


@Service
public class DoctorService {

	@Autowired
	private DoctorRepo dr;

	 
	public ResponseStructure<Doctor> saveDoctor(Doctor d) {
		 Doctor saved= dr.save(d);
		  ResponseStructure<Doctor> rs= new ResponseStructure<Doctor>();
		  rs.setStatuscode(HttpStatus.CREATED.value());
		  rs.setMsg("Doctor saved succesfully");
		  rs.setData(saved);
		  return rs;
	}
}
