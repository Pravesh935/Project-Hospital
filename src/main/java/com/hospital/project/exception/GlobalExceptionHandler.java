package com.hospital.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hospital.project.ResponseStructure;


@RestControllerAdvice
public class GlobalExceptionHandler {

	public ResponseStructure<String> handlePatientNotFoundException(DoctorNotFoundException dx ) {
		ResponseStructure<String> rs = new ResponseStructure<>();

		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setMsg("Patient Not Found");
		rs.setData("No Patient found with given ID");
		return rs;

	}
}
