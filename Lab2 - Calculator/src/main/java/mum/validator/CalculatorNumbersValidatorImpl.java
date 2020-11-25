package mum.validator;

import mum.domain.CalculatorNumbers;

import java.util.ArrayList;
import java.util.List;

public class CalculatorNumbersValidatorImpl implements CalculatorNumbersValidator{
    @Override
    public List<String> validate(Object object) {

        List<String> errors = new ArrayList<String>();

        CalculatorNumbers calculatorNumbers = (CalculatorNumbers) object;
        Double add1 = calculatorNumbers.getAdd1();
        Double add2 = calculatorNumbers.getAdd2();
        Double mult1 = calculatorNumbers.getMult1();
        Double mult2 = calculatorNumbers.getMult2();

        if(add1 == null && add2 == null && mult1 == null && mult2 == null){
            errors.add("Values to add or multiply must be provided");
        }

        if(add1 == null && add2 != null ){
            errors.add("2nd value to add must be provided");
        }

        if(mult1 == null && mult2 != null){
            errors.add("2nd value to be multiplied must be provided");
        }

        return errors;
    }
}
