package fr.natan.cleanarchi_ms_project.infra.input.feignclientsfallback;

import fr.natan.cleanarchi_ms_project.domain.exceptions_metiers.ExceptionWarnMsg;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.entities.EmployeeModel;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.services.EmployeeServiceProxy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EmployeeServiceProxyFallback implements EmployeeServiceProxy {
    @Override
    public EmployeeModel getEmployeeByID(String employeeID) {
        EmployeeModel emptyEmployee = new EmployeeModel();
        emptyEmployee.setEmployeeID(ExceptionWarnMsg.EMPLOYEE_API_ERROR.toString());
        emptyEmployee.setFirstname(ExceptionWarnMsg.EMPLOYEE_API_ERROR.toString());
        emptyEmployee.setLastname(ExceptionWarnMsg.EMPLOYEE_API_ERROR.toString());
        emptyEmployee.setEmail(ExceptionWarnMsg.EMPLOYEE_API_ERROR.toString());
        emptyEmployee.setHireDate(LocalDateTime.now());
        emptyEmployee.setEmployeeType(null);
        emptyEmployee.setEmployeeState(null);
        return emptyEmployee;
    }
}
