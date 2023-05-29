package fr.natan.cleanarchi_ms_employee.infra.input.exception_handler;

import fr.natan.cleanarchi_ms_employee.domain.exception_metrier.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(value = EmployeeAlreadyExistsException.class)
    private ResponseEntity<String> handleEmployeeAlreadyExistsException(){
        return new ResponseEntity<>(ExceptionWarnMsg.EMPLOYEE_ALREADY_EXISTS_EXCEPTION.getException(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = EmployeeFieldsInvalidException.class)
    private ResponseEntity<String> handleEmployeeFieldsEmptyException(){
        return new ResponseEntity<>(ExceptionWarnMsg.EMPLOYEE_FIELDS_EMPTY_EXCEPTION.getException(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = EmployeeNotFoundException.class)
    private ResponseEntity<String> handleEmployeeNotFoundException(){
        return new ResponseEntity<>(ExceptionWarnMsg.EMPLOYEE_NOT_FOUND_EXCEPTION.getException(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = EmployeeCreationErrorDueToAddressAPIException.class)
    private ResponseEntity<Object> handleEmployeeCreationErrorDueToAddressAPIException(EmployeeCreationErrorDueToAddressAPIException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = EmployeeAssociatedProjectsException.class)
    private ResponseEntity<String> handleEmployeeAssociatedProjectsException(){
        return new ResponseEntity<>(ExceptionWarnMsg.EMPLOYEE_ASSOCIATED_PROJECTS_EXCEPTION.getException(), HttpStatus.NOT_ACCEPTABLE);
    }
}
