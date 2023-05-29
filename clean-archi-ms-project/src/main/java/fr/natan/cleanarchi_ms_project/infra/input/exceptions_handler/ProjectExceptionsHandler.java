package fr.natan.cleanarchi_ms_project.infra.input.exceptions_handler;

import fr.natan.cleanarchi_ms_project.domain.exceptions_metiers.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProjectExceptionsHandler {
    @ExceptionHandler(value = ProjectAlreadyExistsException.class)
    private ResponseEntity<String> handleProjectAlreadyExistsException() {
        return new ResponseEntity<>(ExceptionWarnMsg.PROJECT_ALREADY_EXISTS_EXCEPTION.getException(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = ProjectNotFoundException.class)
    private ResponseEntity<Object> handleProjectNotFoundException() {
        return new ResponseEntity<>(ExceptionWarnMsg.PROJECT_NOT_FOUND_EXCEPTION.getException(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = ProjectFieldsEmptyException.class)
    private ResponseEntity<Object> handleProjectFieldsEmptyException() {
        return new ResponseEntity<>(ExceptionWarnMsg.PROJECT_FIELDS_EMPTY_EXCEPTION.getException(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = ProjectCreationErrorDueToEmployeeAPIException.class)
    private ResponseEntity<Object> handleProjectCreationErrorDueToEmployeeAPI(ProjectCreationErrorDueToEmployeeAPIException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = ProjectCreationErrorDueToCompanyAPIException.class)
    private ResponseEntity<Object> handleProjectCreationErrorDueToCompanyAPI(ProjectCreationErrorDueToCompanyAPIException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = ProjectCreationErrorDueToNotAcceptedEmployeeStateException.class)
    private ResponseEntity<String> handleProjectCreationErrorDueToStateOfEmployeeException() {
        return new ResponseEntity<>(ExceptionWarnMsg.EMPLOYEE_STATE_NOT_ACCEPTED_EXCEPTION.getException(), HttpStatus.NOT_ACCEPTABLE);
    }
@ExceptionHandler(value = CompanyIsAssiacetedToProjectException.class)
    private ResponseEntity<Object> handleCompanyIsAssociatedToProjectException(){
        return new ResponseEntity<>(ExceptionWarnMsg.COMPANY_IS_ASSOCIATED_TO_PROJECT_EXCEPTION.getException(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = EmployeeIsAssiacetedToProjectException.class)
    private ResponseEntity<String> handleEmployeeIsAssociatedToProjectException(){
        return new ResponseEntity<>(ExceptionWarnMsg.EMPLOYEE_IS_ASSOCIATED_TO_PROJECT_EXCEPTION.getException(), HttpStatus.NOT_ACCEPTABLE);
    }
}
