package fr.natan.cleanarchi_ms_employee.infra.output.model;

import fr.natan.cleanarchi_ms_employee.domain.entity.EmployeeState;
import fr.natan.cleanarchi_ms_employee.domain.entity.EmployeeType;
import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.models.AddressModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@AllArgsConstructor @NoArgsConstructor @Data
public class EmployeeModel {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String employeeID;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDateTime hireDate;
    @Enumerated(EnumType.STRING)
    private EmployeeState employeeState;
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    private Long addressID;
    @Transient
    private AddressModel address;
}
