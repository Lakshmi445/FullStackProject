package com.example.FullStackProject.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.FullStackProject.InterfaceForDef.SoftwareIntForDef;
import com.example.FullStackProject.Model.Administration;
import com.example.FullStackProject.Model.Software;



@Controller
public class SoftwareController {
	public SoftwareIntForDef service;

	public SoftwareController(SoftwareIntForDef service) {
		this.service = service;
	}
	@GetMapping("/viewAllSoftwares")
	public String listOfsoftwares(Model model) {
	model.addAttribute("softwareList",service.fetchAllRecords());
	return "software";//software.html
	}
	@GetMapping("software/createNewSoftware")
	public String createSoftware(Model model) {
		Software emptyObj=new Software();
		model.addAttribute("softobj", emptyObj);
		return "createSoftware";
		
	}
	@PostMapping("/insertSoftwares")
	public String InsertIntoDataBase(@ModelAttribute("softobj")Software obj) {
		service.saveSoftware(obj);//obj is insert into db by using save
		return "redirect:/viewAllSoftwares";
	}
	@GetMapping("/delete/{id}")
	public String deletesoftware(@PathVariable int id) {
	service.deletesoftware(id);
	return "redirect:/viewAllSoftwares";
	}
	@GetMapping("/update/{id}")
	public String updatesoftware(@PathVariable int id , Model model) {
	   model. addAttribute("updateSoftware", service.updateSoftware(id));
	return "updateSoftware";
	}
	@PostMapping("/updateAndSave/{id}")
	public String updateandSave(@PathVariable int id,
			@ModelAttribute("updateSoftware") Software newVal) {
	Software existingSof = service.updateSoftware(id);
existingSof.setSoftwarename(newVal.getSoftwarename());
existingSof.setPrice(newVal.getPrice());
existingSof.setStock(newVal.getStock());


	service.saveSoftware(existingSof);
	return "redirect:/viewAllSoftwares";
	}
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	@GetMapping("/contactme")
	public String contact() {
			return "contact";
	}
	@GetMapping("/aboutme")
	public String about() {
			return "about";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		Administration admin= new Administration();
		model.addAttribute("adminObj",admin);
		return "login";
	}
	@GetMapping("/validationData")
	public String validateLogin(@ModelAttribute("adminObj")Administration adminDetails) {
		if(adminDetails.getUsername().equals("administrationlogin")&& adminDetails.getPassword().equals("LoginPassword")) {
			return "redirect:/viewAllSoftwares";
		}
		else {
			return "redirect:/login";
		}
	}
	
	
}
