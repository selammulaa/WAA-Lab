package mum.edu.controller;


import java.io.IOException;

import mum.edu.domain.Calculator;
import mum.edu.service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CalculatorController {

    final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(value = {"/", "/Calculator"})
    public String inputCalc() throws Exception {

        return "CalculatorForm";
    }

    @PostMapping(value = "/Calculator")
    public String handleCalc(Calculator calculator, Model model, RedirectAttributes redirectAttributes) throws Exception {

        if (calculator.getAdd1() != null &&
                calculator.getAdd2() != null)
            calculatorService.add(calculator);

        if (calculator.getMult1() != null &&
                calculator.getMult2() != null)
            calculatorService.mult(calculator);

        redirectAttributes.addFlashAttribute("calculator", calculator);
        String heading = "Good Job, Selam!";
        redirectAttributes.addAttribute("heading", "Selam!");

        return "redirect:results";
    }


    @GetMapping(value = "/results")
    public String calculatorResults(Model model) throws IOException {

        Calculator calculator = (Calculator) (((ModelMap) model).get("calculator"));

        if (calculator == null)
            throw new IOException("The calculation is Obsolete, Try Again!");

        return "CalculatorView";
    }


}
