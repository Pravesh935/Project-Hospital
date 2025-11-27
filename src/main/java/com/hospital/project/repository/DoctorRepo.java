package com.hospital.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.project.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}
