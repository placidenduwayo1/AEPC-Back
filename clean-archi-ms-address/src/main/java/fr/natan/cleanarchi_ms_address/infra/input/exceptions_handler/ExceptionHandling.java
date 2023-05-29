package fr.natan.cleanarchi_ms_address.infra.input.exceptions_handler;

import fr.natan.cleanarchi_ms_address.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(value = AddressAlreadyExistsException.class)
    private ResponseEntity<String> handleAddressAlreadyExistsException() {
        return new ResponseEntity<>(ExceptionsWarnMessage.ADDRESS_ALREADY_EXISTS_EXCEPTION.getException(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = AddressNotFoundException.class)
    private ResponseEntity<String> handleAddressNotFoundException() {
        return new ResponseEntity<>(ExceptionsWarnMessage.ADDRESS_NOT_FOUND_EXCEPTION.getException(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = AddressFieldsEmptyException.class)
    private ResponseEntity<String> handleAddressFieldsEmptyException() {
        return new ResponseEntity<>(ExceptionsWarnMessage.FIELDS_EMPTY_EXCEPTION.getException(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = AddressNumInvalidException.class)
    private ResponseEntity<Object> handleAddressNumInvalidException() {
        return new ResponseEntity<>(ExceptionsWarnMessage.ADDRESS_NUM_INVALID_EXCEPTION, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = AddressPBInvalidException.class)
    private ResponseEntity<Object> handleAddressPBInvalidException() {
        return new ResponseEntity<>(ExceptionsWarnMessage.ADDRESS_PB_INVALID_EXCEPTION, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = AddressAssignedEmployeesException.class)
    private ResponseEntity<Object> handleAddressAssignedEmployeesException(){
        return new ResponseEntity<>(ExceptionsWarnMessage.ADDRESS_ASSIGNED_EMPLOYEES_EXCEPTION, HttpStatus.NOT_ACCEPTABLE);
    }
}
