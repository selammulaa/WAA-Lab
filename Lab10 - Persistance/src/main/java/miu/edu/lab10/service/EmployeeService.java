package miu.edu.lab10.service;

import miu.edu.lab10.domain.Employee;

import java.util.List;


public interface EmployeeService {

	public void save(Employee employee);
	public List<Employee> findAll();
	public Employee findByEmployeeNumber(Long employeeId);
}
