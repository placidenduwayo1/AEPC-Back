package fr.natan.cleanarchi_ms_employee.infra.output.model;

import fr.natan.cleanarchi_ms_employee.domain.entity.EmployeeState;
import fr.natan.cleanarchi_ms_employee.domain.entity.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class EmployeeDto {
    private String firstname;
    private String lastname;
    private EmployeeState employeeState;
    private EmployeeType employeeType;
    private Long addressID;
}
