package mum.controller;

import mum.domain.CalculatorNumbers;
import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.annotation.Controller;
import mum.edu.framework.annotation.RequestMapping;
import mum.validator.CalculatorNumbersValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CalculatorController {

    @AutoWired
    CalculatorNumbersValidator calculatorNumbersValidator;

    @RequestMapping(value = {"/", "/calc_show"})
    public String calcShow(HttpServletRequest request, HttpServletResponse response){
        return "/WEB-INF/calculator.jsp";
    }

    @RequestMapping(value = "/calc")
    public String calculate(CalculatorNumbers calculatorNumbers, HttpServletRequest request, HttpServletResponse response){
        List<String> errors = calculatorNumbersValidator.validate(calculatorNumbers);
        if(errors.isEmpty()){
            calculatorNumbers.setSum(calculatorNumbers.getAdd1() + calculatorNumbers.getAdd2());
            calculatorNumbers.setProduct(calculatorNumbers.getMult1() + calculatorNumbers.getMult2());
            request.setAttribute("calc", calculatorNumbers);
            return "/WEB-INF/result.jsp";
        }else {
            request.setAttribute("errors", errors);
            request.setAttribute("calc", calculatorNumbers);
            return "/WEB-INF/calculator.jsp";
        }
    }
}
