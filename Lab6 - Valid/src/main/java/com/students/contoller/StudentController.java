package com.students.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.students.domain.Student;

import javax.validation.Valid;

@Controller
public class StudentController {

    @GetMapping(value = "/registration")
    public String showForm(@ModelAttribute("student") Student student, Model model) {

        return "registration";
    }

    @PostMapping(value = "/registration")
    public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";

        } else {
            return "success";
        }

    }

}

	

