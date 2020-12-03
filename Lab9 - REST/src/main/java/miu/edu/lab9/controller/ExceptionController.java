package miu.edu.lab9.controller;

import java.util.List;
import java.util.Locale;

import miu.edu.lab9.domain.dto.DomainError;
import miu.edu.lab9.domain.dto.DomainErrors;
import miu.edu.lab9.exception.EmployeeException;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ExceptionController {

    final MessageSourceAccessor messageSourceAccessor;
    final MessageSource messageSource;

    public ExceptionController(MessageSourceAccessor messageSourceAccessor, MessageSource messageSource) {
        this.messageSourceAccessor = messageSourceAccessor;
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public DomainErrors handleException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        DomainErrors errors = new DomainErrors();
        errors.setErrorType("ValidationError");
        for (FieldError fieldError : fieldErrors) {
            DomainError error = new DomainError(messageSourceAccessor.getMessage(fieldError));
//            DomainError error = new DomainError(fieldError.getDefaultMessage());
            errors.addError(error);
        }

        return errors;
    }

    @ExceptionHandler(EmployeeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    DomainErrors handleError(EmployeeException exception) {

        DomainErrors errors = new DomainErrors();
        errors.setErrorType("EmployeeException");

        errors.setMessage(exception.getFullMessage());
        return errors;
    }

}