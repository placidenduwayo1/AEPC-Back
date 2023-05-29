package fr.natan.cleanarchi_ms_address.infra.input.feignclient.service;

import fr.natan.cleanarchi_ms_address.infra.input.feignclient.entity.EmployeeModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CLEAN-ARCHI-BS-MS-EMPLOYEE")
public interface EmployeeServiceProxy {
    @GetMapping(value = "/employees/addresses/{addressID}", produces = "application/json")
    List<EmployeeModel> getEmployeesLivingAtGivenAddress(@PathVariable(name = "addressID") Long addressID);
}
