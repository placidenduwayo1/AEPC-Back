package fr.natan.cleanarchi_ms_employee.domain.ports.output;

import fr.natan.cleanarchi_ms_employee.domain.entity.Employee;
import fr.natan.cleanarchi_ms_employee.domain.exception_metrier.EmployeeNotFoundException;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.models.AddressModel;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.models.ProjectModel;
import fr.natan.cleanarchi_ms_employee.infra.output.model.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeOutputService {
    List<Employee> getAllEmployees();
    Employee createEmployee(Employee employee);
    AddressModel getAddressByID(Long addressD);
    List<Employee> getEmployeeByInfo(EmployeeDto employeeDto);
    Optional<Employee> getEmployeeByID(String employeeID) throws EmployeeNotFoundException;
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    List<Employee> getEmployeesLivingAtGivenAddress(Long addressID);
    List<ProjectModel> getProjectsAssignedToEmployee(String employeeID);
}
