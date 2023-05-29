package fr.natan.cleanarchi_ms_company.infra.input.feignclient.service;

import fr.natan.cleanarchi_ms_company.infra.input.feignclient.model.ProjectModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CLEAN-ARCHI-BS-MS-PROJECT")
public interface ProjectServiceProxy {
    @GetMapping(value = "/projects/companies/{companyID}", produces = "application/json")
    List<ProjectModel> getProjectsAssignedCompany(@PathVariable(name = "companyID") String companyID);
}
