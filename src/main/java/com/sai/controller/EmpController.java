package com.sai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sai.entity.Employee;
import com.sai.service.EmpService;

@RestController

public class EmpController {
	@Autowired
	EmpService empser;
	
	@PostMapping("/add")
	public ResponseEntity<String> addData(@RequestBody Employee emp)
	{
		ResponseEntity<String> res=null;
		try
		{
	    String body=empser.savEmployee(emp);
	    res=new ResponseEntity<String>(body,HttpStatus.OK);	
		}
		catch (Exception e) {
			String body="not added";
		    res=new ResponseEntity<String>(body,HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return res;	
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll()
	{
		ResponseEntity<?> res=null;
		try
		{
	    List<Employee> list=empser.findAll();
	    res=new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		}catch (Exception e) {
		    res=new ResponseEntity<String>("unable to fetch",HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
		}
		return res;
}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id)
	{
		ResponseEntity<?> res=null;
		try
		{
	    Optional<Employee> emp=empser.findById(id);
	    res=new ResponseEntity<Optional<Employee>>(emp,HttpStatus.OK);
		}catch (Exception e) {
		    res=new ResponseEntity<String>("unable to fetch",HttpStatus.INTERNAL_SERVER_ERROR);
		    e.printStackTrace();	
		}
		return res;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> getOnebyDelete(@PathVariable Integer id)
	{
		ResponseEntity<String> res=null;
		try
		{
	    String  emp=empser.deleteById(id);
	    res=new ResponseEntity<String>(emp,HttpStatus.OK);
		}catch (Exception e) {
		    res=new ResponseEntity<String>("unable to delete",HttpStatus.INTERNAL_SERVER_ERROR);
		    e.printStackTrace();
		}
		return res;
	}
	@PutMapping("/update")
	public ResponseEntity<String> getOnebyOneUpdate(@RequestBody Employee emp)
	{
		ResponseEntity<String> res=null;
		try
		{
	    String  empw=empser.updateEmployee(emp);
	    res=new ResponseEntity<String>(empw,HttpStatus.OK);
		}catch (Exception e) {
		    res=new ResponseEntity<String>("unable to update",HttpStatus.INTERNAL_SERVER_ERROR);
		    e.printStackTrace();
			
		}
		return res;
	}	
}
