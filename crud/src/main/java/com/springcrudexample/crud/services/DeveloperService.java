package com.springcrudexample.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcrudexample.crud.dtos.DeveloperRequest;
import com.springcrudexample.crud.models.DeveloperModel;
import com.springcrudexample.crud.repositories.DeveloperRepository;

@Service
public class DeveloperService {

	@Autowired
	private DeveloperRepository developerRepository;
	
	public List<DeveloperModel> findAll(){
		return developerRepository.findAll();
	}
	
	public DeveloperModel addDeveloper(DeveloperRequest request) {
		DeveloperModel model = new DeveloperModel();
		model.setName(request.getName());
		model.setSurname(request.getSurname());
		return developerRepository.save(model);
	}
	
	public DeveloperModel findById(Long id) {
		return developerRepository.getOne(id);
	}
	
	public DeveloperModel updateDeveloper(Long id, DeveloperRequest request) {
		DeveloperModel updatedModel = Optional.ofNullable(developerRepository.getOne(id)).map(developer -> {
			developer.setName(request.getName());
			developer.setSurname(request.getSurname());
			return developer;
		}).get();
		return developerRepository.save(updatedModel);
	}
	
	public void deleteDeveloper(Long id) {
		developerRepository.deleteById(id);
	}
}
