package springboot.spring_boot_example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.spring_boot_example.exception.RecordNotFoundException;
import springboot.spring_boot_example.model.EmployeeEntity;
import springboot.spring_boot_example.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/get")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees(){
		List<EmployeeEntity> allEmps = service.getAllEmployees();
		return new ResponseEntity<List<EmployeeEntity>>(allEmps, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getEmpById(Long id) throws RecordNotFoundException{
		EmployeeEntity emp = service.getEmployeeById(id);
		return new ResponseEntity<EmployeeEntity>(emp, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<EmployeeEntity> createOrUpdate(@RequestBody EmployeeEntity entity) throws RecordNotFoundException {
		EmployeeEntity updatedEntity = service.createOrUpdateEmployee(entity);
		return new ResponseEntity<EmployeeEntity>(updatedEntity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteById(Long id) throws RecordNotFoundException {
		service.deleteEmployeeById(id);
		return HttpStatus.NOT_FOUND;
	}
	
}
