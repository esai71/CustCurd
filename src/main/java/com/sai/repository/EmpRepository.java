package com.sai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.entity.Employee;
@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {


}
