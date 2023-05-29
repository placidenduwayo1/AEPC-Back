package fr.natan.cleanarchi_ms_employee.infra.input.controller;

import fr.natan.cleanarchi_ms_employee.domain.entity.Employee;
import fr.natan.cleanarchi_ms_employee.domain.exception_metrier.*;
import fr.natan.cleanarchi_ms_employee.domain.ports.input.EmployeeInputService;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.models.ProjectModel;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.services.AddressServiceProxy;
import fr.natan.cleanarchi_ms_employee.infra.output.model.EmployeeDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("CodeBlock2Expr")
@RestController
public class EmployeeController {
    public final EmployeeInputService employeeInputService;
    private final AddressServiceProxy addressServiceProxy;

    public EmployeeController(EmployeeInputService employeeInputService, @Qualifier("address-service-proxy") AddressServiceProxy addressServiceProxy) {
        this.employeeInputService = employeeInputService;
        this.addressServiceProxy = addressServiceProxy;
    }


    @GetMapping(value = "/employees", produces = "application/json")
    public List<Employee> getEmployees(){
        List<Employee> employees = employeeInputService.getAllEmployees();
        employees.forEach(employee -> employee.setAddress(addressServiceProxy.getAddressById(employee.getAddressID())));

        return employees;
    }

    @PostMapping(value = "/employees")
    public Employee createEmployee(@RequestBody EmployeeDto employeeDto) throws EmployeeFieldsInvalidException,
            EmployeeAlreadyExistsException, EmployeeCreationErrorDueToAddressAPIException {
        Employee createdEmployee = employeeInputService.createEmployee(employeeDto);
        createdEmployee.setAddress(addressServiceProxy.getAddressById(createdEmployee.getAddressID()));

        return createdEmployee;
    }

    @PutMapping(value = "/employees/{employeeID}")
    public Employee updateEmployee(@PathVariable(name = "employeeID") String employeeID, @RequestBody EmployeeDto employeeDto)
            throws EmployeeNotFoundException, EmployeeFieldsInvalidException, EmployeeCreationErrorDueToAddressAPIException,
            EmployeeAlreadyExistsException {
        Employee employee = employeeInputService.updateEmployee(employeeID, employeeDto);
        employee.setAddress(addressServiceProxy.getAddressById(employee.getAddressID()));
        return employee;
    }

    @GetMapping(value = "/employees/{employeeID}", produces = "application/json")
    public Optional<Employee> getEmployeeByID(@PathVariable(name = "employeeID") String employeeID) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeInputService.getEmployeeByID(employeeID);
        employee.get().setAddress(addressServiceProxy.getAddressById(employee.get().getAddressID()));
        return employee;
    }

    @DeleteMapping(value = "/employees/{employeeID}")
    public void deleteEmployee(@PathVariable(name = "employeeID") String employeeID) throws EmployeeNotFoundException,
            EmployeeAssociatedProjectsException {
        employeeInputService.deleteEmployee(employeeID);
    }

    @GetMapping(value = "/employees/addresses/{addressID}", produces = "application/json")
    public List<Employee> getEmployeesLivingGivenAddress(@PathVariable(name = "addressID") Long addressID){
        List<Employee> employees = employeeInputService.getEmployeesLivingAtGivenAddress(addressID);
        employees.forEach(employee ->
            employee.setAddress(addressServiceProxy.getAddressById(employee.getAddressID())));

        return employees;
    }
    @GetMapping(value = "/projects/employees/{employeeID}", produces = "application/json")
    public List<ProjectModel> getProjectsAssignedToEmployee(@PathVariable(name = "employeeID") String employeeID) throws EmployeeNotFoundException {
        return employeeInputService.getProjectsAssignedToEmployee(employeeID);
    }
}
