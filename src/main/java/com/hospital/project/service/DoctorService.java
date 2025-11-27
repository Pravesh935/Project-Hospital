package com.hospital.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hospital.project.ResponseStructure;
import com.hospital.project.entity.Doctor;
import com.hospital.project.exception.DoctorNotFoundException;
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
	public ResponseStructure<Doctor> findById(int id) {
		Doctor d = dr.findById(id).orElseThrow(() -> new DoctorNotFoundException());
		ResponseStructure rs = new ResponseStructure<Doctor>();

		if (d != null) {
			rs.setStatuscode(HttpStatus.FOUND.value());
			rs.setMsg("Doctor with Id " + id + " Found ");
			rs.setData(d);
		}
		return rs;
	}
	
	
//	Student Delete method()
	public ResponseStructure<String> deleteById(int id) {
		Doctor d = dr.findById(id).orElseThrow(() -> new DoctorNotFoundException());

		dr.delete(d);

		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMsg("Student deleted successfully");
		rs.setData("Deleted Id: " + id);

		return rs;
	}
	
	
//	update method()
	public ResponseStructure<Doctor> updateById(int id, Doctor newData) {

		Doctor old = dr.findById(id).orElseThrow(() -> new DoctorNotFoundException());
				

		// Only update fields, not the ID
		old.setName(newData.getName());
//		old.setId(newData.getId());
//		old.setSpecialization(newData.getSpecialization());

		Doctor updated = dr.save(old);

		ResponseStructure<Doctor> rs = new ResponseStructure<>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMsg("Student updated successfully");
		rs.setData(updated);

		return rs;
	}



	
}
