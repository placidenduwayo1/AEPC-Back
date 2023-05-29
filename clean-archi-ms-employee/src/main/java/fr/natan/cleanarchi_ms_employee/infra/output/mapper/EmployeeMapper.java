package fr.natan.cleanarchi_ms_employee.infra.output.mapper;

import fr.natan.cleanarchi_ms_employee.domain.entity.Employee;
import fr.natan.cleanarchi_ms_employee.infra.output.model.EmployeeDto;
import fr.natan.cleanarchi_ms_employee.infra.output.model.EmployeeModel;
import org.springframework.beans.BeanUtils;

public class EmployeeMapper {

    private EmployeeMapper(){}
    public static Employee mapEmployeeModelToClass(EmployeeModel employeeModel) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeModel, employee);

        return employee;
    }

    public static EmployeeModel mapClassToModel(Employee employee){
        EmployeeModel employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employee, employeeModel);
        return employeeModel;
    }

    public static Employee mapDtoToClass(EmployeeDto employeeDto){
        Employee employee = new Employee();
       BeanUtils.copyProperties(employeeDto, employee);

        return employee;
    }
}
