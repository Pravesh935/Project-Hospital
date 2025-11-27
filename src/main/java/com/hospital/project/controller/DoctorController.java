package com.hospital.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.project.ResponseStructure;
import com.hospital.project.entity.Doctor;
import com.hospital.project.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService ds;

	@PostMapping("/save")
	public ResponseStructure<Doctor> saveDoctor(@RequestBody Doctor d) {
		return ds.saveDoctor(d);
	}
	

}
