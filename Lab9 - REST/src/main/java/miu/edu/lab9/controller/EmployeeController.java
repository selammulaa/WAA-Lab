package miu.edu.lab9.controller;

import javax.validation.Valid;

import miu.edu.lab9.domain.Employee;
import miu.edu.lab9.exception.EmployeeException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping({"/","/employee"})
public class EmployeeController {
	
	@GetMapping(value="/")
	public String display() {
		
		return "employee";
	}
		
	@PostMapping(value = "/add")
	public @ResponseBody Employee add(@Valid  @RequestBody  Employee employee)  throws EmployeeException {

		if (employee.getFirstName().equals("Ex")) {
			throw new EmployeeException(employee.getEmail(), "Unable to save employee with email: ");
		}
			
		return employee;
	}
	

	
	
}
