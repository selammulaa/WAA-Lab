package edu.mum.controller;

import edu.mum.domain.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.service.CalculatorService;
 

@Controller
public class CalculatorController {

  CalculatorService calculatorService;

  public CalculatorController(CalculatorService calculatorService){
      this.calculatorService = calculatorService;
  }
  
  @GetMapping(value={"/","/Calculator"})
  public String inputCalc(Calculator calculator ) throws Exception {
   	  
       return  "CalculatorForm" ;    
   }
   
  @PostMapping(value= "/Calculator")
  public String handleCalc( Calculator calculator ) throws Exception {

 		if (calculator.getAdd1() != null &&
			 calculator.getAdd2() != null)
		     calculatorService.add(calculator);
 
		if (calculator.getMult1() != null &&
				 calculator.getMult2() != null)
			calculatorService.mult(calculator);

       return  "CalculatorView" ; 
   }
   
 
}
