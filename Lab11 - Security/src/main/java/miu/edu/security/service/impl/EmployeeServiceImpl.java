package miu.edu.security.service.impl;

import java.util.List;

import miu.edu.security.domain.Employee;
import miu.edu.security.repository.EmployeeRepository;
import miu.edu.security.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee findByEmployeeNumber(Long employeeId) {
        return employeeRepository.findByEmployeeNumber(employeeId);
    }

}
