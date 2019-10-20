package com.springcrudexample.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcrudexample.crud.dtos.DeveloperRequest;
import com.springcrudexample.crud.models.DeveloperModel;
import com.springcrudexample.crud.services.DeveloperService;

@RestController
@RequestMapping(value="/developer", produces="application/json")
public class DeveloperController {

	@Autowired
	private DeveloperService developerService;
	
	@RequestMapping(value="/list")
	public List<DeveloperModel> listAllDevelopers(){
		return developerService.findAll();
	}
	
	@RequestMapping(value="/list/{id}")
	public DeveloperModel findById(@PathVariable Long id) {
		return developerService.findById(id);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public DeveloperModel addDeveloper(@RequestBody DeveloperRequest request) {
		return developerService.addDeveloper(request);		
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public DeveloperModel updateDeveloper(@PathVariable Long id, @RequestBody DeveloperRequest request) {
		return developerService.updateDeveloper(id, request);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public boolean deleteDeveloper(@PathVariable Long id) {
		developerService.deleteDeveloper(id);
		return true;
	}
}
