package com.example.FullStackProject.InterfaceForDef;

import java.util.List;

import com.example.FullStackProject.Model.Software;



public interface SoftwareIntForDef {
	Software saveSoftware(Software obj);
	List<Software> fetchAllRecords();
	//Software fetchAllRecord(int id)throws Exception;
	Software updateSoftware(int id);
	void deletesoftware(int id);
	
	

}
