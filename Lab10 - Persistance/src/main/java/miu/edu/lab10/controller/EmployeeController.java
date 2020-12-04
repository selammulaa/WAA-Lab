package miu.edu.lab10.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import miu.edu.lab10.domain.Employee;
import miu.edu.lab10.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping({"/employees"})
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = {"", "/list"})
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees";
    }

    @GetMapping("/employee")
    public String getEmployeeById(Model model, @RequestParam("id") Long employeeId) {
        Employee employee = employeeService.findByEmployeeNumber(employeeId);
        model.addAttribute("employee", employee);
        return "employee";
    }


    @GetMapping(value = "/add")
    public String getAddNewEmployeeForm(@ModelAttribute("newEmployee") Employee newEmployee) {
        return "addEmployee";
    }

    @PostMapping(value = "/add")
    public String processAddNewEmployeeForm(@ModelAttribute("newEmployee") @Valid Employee employeeToBeAdded,
                                            BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addEmployee";
        }

        try {
            employeeService.save(employeeToBeAdded);
        } catch (Exception up) {
            System.out.println("Transaction Failed!!!");

        }

        return "redirect:/employees/list";
    }


}
