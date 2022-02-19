package com.sai.service;

import java.util.List;
import java.util.Optional;

import com.sai.entity.Employee;

public interface EmpService {
	public String savEmployee(Employee emp);
	public List<Employee> findAll();
	public Optional<Employee> findById(Integer id);
	public String deleteById(Integer id);
	public String updateEmployee(Employee emp);

}
