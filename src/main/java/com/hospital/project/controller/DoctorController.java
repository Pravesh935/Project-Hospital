package com.hospital.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseStructure<Doctor> saveStud(@RequestBody Doctor d) {
		return ds.saveDoctor(d);
	}
	
	
	@GetMapping("/findstud")
	public ResponseStructure<Doctor> findDoctor(@RequestParam int id) {
		return ds.findById(id);
	}
   @DeleteMapping("/delete")
   public ResponseStructure<String> deleteDoctor(@RequestParam int id){
	 return ds.deleteById(id);
	   
   }
   @PatchMapping("/update")
   public ResponseStructure<Doctor> updateDoctor(@PathVariable int id, @RequestBody Doctor d ){
	   return ds.updateById(id, d);
   }

}
