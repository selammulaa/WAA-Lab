package miu.edu.security.service;


import miu.edu.security.domain.Employee;

import java.util.List;


public interface EmployeeService {

	public void save(Employee employee);
	public List<Employee> findAll();
	public Employee findByEmployeeNumber(Long employeeId);
}
