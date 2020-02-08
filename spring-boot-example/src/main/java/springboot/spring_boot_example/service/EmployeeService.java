package springboot.spring_boot_example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.spring_boot_example.dao.EmployeeRepository;
import springboot.spring_boot_example.exception.RecordNotFoundException;
import springboot.spring_boot_example.model.EmployeeEntity;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	public List<EmployeeEntity> getAllEmployees(){
		List<EmployeeEntity> allEmpList = repository.findAll();
		
		if(allEmpList.size() > 0) {
			return allEmpList;
		}
		return new ArrayList<EmployeeEntity>();
	}
	
	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new RecordNotFoundException("No employee found with given id");
		
	}
	
	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException {
//		Optional<EmployeeEntity> empEntity = repository.findById(entity.getId());
//		
//		if(empEntity.isPresent()) {
//			EmployeeEntity emp = empEntity.get();
//			emp.setEmail(entity.getEmail());
//			emp.setFirstName(entity.getFirstName());
//			emp.setLastName(entity.getLastName());
//			
//			repository.save(emp);
//			return emp;
//		}else {
		repository.save(entity);
		return entity;
	//	}
	}
	
	public void deleteEmployeeById(Long id) throws RecordNotFoundException{
		Optional<EmployeeEntity> empEntity = repository.findById(id);
		
		if(empEntity.isPresent()) {
			repository.deleteById(id);
		}
		throw new RecordNotFoundException("No employee found with given id");
	}
}
