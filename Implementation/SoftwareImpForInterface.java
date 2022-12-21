package com.example.FullStackProject.Implementation;

import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.FullStackProject.InterfaceForDef.SoftwareIntForDef;
import com.example.FullStackProject.Model.Software;
import com.example.FullStackProject.SoftwareInterface.SoftwareInt;



@Service
public  class SoftwareImpForInterface implements SoftwareIntForDef {
	private SoftwareInt software;
	private Object softobj;

	public SoftwareImpForInterface(SoftwareInt software) {  //@Autowired  don't need to write it because it is only 1 attr
		this.software = software;
	}
	
	@Override
	public List<Software> fetchAllRecords(){
		return software.findAll();     //select*from software
	}
	@Override
	public Software saveSoftware(Software obj) {
		return software.save(obj);
	}
	@Override
	public void deletesoftware(int id) {
		 software.deleteById(id);
	}

    public Software updateSoftware(int id) {
	return	software.findById(id).get();
	}


}
	
	
	


	
		

	
	
		
	
	
		

	
	
		
	


