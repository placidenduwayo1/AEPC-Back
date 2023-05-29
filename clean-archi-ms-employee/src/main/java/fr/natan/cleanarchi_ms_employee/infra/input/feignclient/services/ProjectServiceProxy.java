package fr.natan.cleanarchi_ms_employee.infra.input.feignclient.services;

import fr.natan.cleanarchi_ms_employee.infra.input.feignclient.models.ProjectModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "CLEAN-ARCHI-BS-MS-PROJECT")
public interface ProjectServiceProxy {
    @GetMapping(value = "/projects/employees/{employeeID}", produces = "application/json")
    List<ProjectModel> getProjectsAssignedToEmployee(@PathVariable(name = "employeeID") String employeeID);
}
