package fr.natan.cleanarchi_ms_employee.infra.config;

import fr.natan.cleanarchi_ms_employee.domain.ports.output.EmployeeOutputService;
import fr.natan.cleanarchi_ms_employee.domain.usecase.EmployeeInputServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConfig {

    @Bean
    public EmployeeInputServiceImpl employeeUseCase(@Autowired EmployeeOutputService employeeOutputService){
        return new EmployeeInputServiceImpl(employeeOutputService);
    }
}
