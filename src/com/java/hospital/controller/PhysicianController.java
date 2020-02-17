package com.java.hospital.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.hospital.model.Physician;
import com.java.hospital.service.PhysicianServiceI;

@Controller
@RequestMapping("/physician")
public class PhysicianController {
	
	@Autowired
	PhysicianServiceI physicianServiceI;
	
	public PhysicianServiceI getPhysicianServiceI() {
		return physicianServiceI;
	}
	public void setPhysicianServiceI(PhysicianServiceI physicianServiceI) {
		this.physicianServiceI = physicianServiceI;
	}
	@RequestMapping("/showPhysician")
	public String addPhysician(Model model){
		
		Physician physician=physicianServiceI.physicianAutoComplete();
		model.addAttribute("physician", physician);
		return "enroll_physician";
	}
	
	@RequestMapping("/viewPhysician")
	public String viewPhysician(Model model) throws ParseException{

		List<Physician> physicianList=physicianServiceI.getAllPhysician();

		model.addAttribute("physicianList",physicianList);
		model.addAttribute("physician",new Physician());
		
		physicianList=null;
		return "view_physician";
	}
	
	@RequestMapping("/savePhysician")
	public String savePatient(@Validated @ModelAttribute("physician") Physician physician, BindingResult bindingResult,Model model) throws ParseException{
		if(bindingResult.hasErrors()) {
			return "enroll_physician";
		}
		physicianServiceI.savePhysician(physician);
		return "redirect:/physician/viewPhysician";
	}


	@RequestMapping("/getPhysician/{id}")
	public String getPhysician(@PathVariable("id") int physicianId,Model model) throws ParseException{

		Physician physician =physicianServiceI.getPhysician(physicianId);
		
		model.addAttribute("physician",physician);
		physician=null;
		return "update_physician";
	}
	
	@RequestMapping("/updatePhysician")
	public String updatePhysician(@ModelAttribute("physician") Physician physician, Model model) throws ParseException{

		physicianServiceI.updatePhysician(physician);

		return "redirect:/physician/viewPhysician";
	}
	@RequestMapping("/deletePhysician/{id}")
	public String deletePhysician(@PathVariable("id") int physicianId) throws ParseException{

		physicianServiceI.deletePhysician(physicianId);

		return "redirect:/physician/viewPhysician";
	}

	@RequestMapping("/searchPhysician")
	public String searchPhysician(@RequestParam("state") String state,@RequestParam("plan") String plan,@RequestParam("department") String department,Model model) throws ParseException{

		System.out.println("Search");
		Physician physician= new Physician();
		physician.setState(state);
		physician.setInsurancePlan(plan);
		physician.setDepartment(department);
		List<Physician> physicianList=physicianServiceI.searchPhysician(physician);

		model.addAttribute("physician", physician);
		model.addAttribute("physicianList",physicianList);
		physician=null;
		physicianList=null;
		return "view_physician";
	}
}
