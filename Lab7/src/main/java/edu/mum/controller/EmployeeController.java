package edu.mum.controller;

import java.io.File;
import java.io.FileNotFoundException;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.domain.Employee;

@org.springframework.stereotype.Controller

public class EmployeeController {

    ServletContext servletContext;

    public EmployeeController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @GetMapping(value = "employee_input")
    public String inputEmployee(@ModelAttribute("employee") Employee employee) {
        return "EmployeeForm";
    }

    @PostMapping(value = "/employee_save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                               Model model) throws FileNotFoundException {

        if (bindingResult.hasErrors()) {
            return "EmployeeForm";
        }

        MultipartFile image = employee.getImage();
        String realPath = servletContext.getRealPath("/");

        if (image != null && !image.isEmpty()) {
            try {
                image.transferTo(new File(realPath + "/images/" + employee.getId() + ".png"));
            } catch (Exception e) {
                throw new FileNotFoundException("Unable to save image: " + image.getOriginalFilename());
            }
        }

        model.addAttribute("employee", employee);

        return "EmployeeDetails";
    }

}
