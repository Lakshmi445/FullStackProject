package com.example.FullStackProject.SoftwareInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FullStackProject.Model.Software;

//save, find,findAll persist

public interface SoftwareInt extends JpaRepository<Software,Integer> {

	
	

}
