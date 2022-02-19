package com.sai.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.entity.Employee;
import com.sai.repository.EmpRepository;
import com.sai.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpRepository emprepo;
	
	@Override
	public String savEmployee(Employee emp) {
		emprepo.save(emp);
	
	
	return "added";
}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return emprepo.findAll();
	}

	@Override
	public Optional<Employee> findById(Integer id) {
		// TODO Auto-generated method stub
		return emprepo.findById(id);
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
				emprepo.deleteById(id);
				return "sucessfully delted";
	}

	@Override
	public String updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
				 emprepo.saveAndFlush(emp);
				 return "Updated";
	
	}

}
