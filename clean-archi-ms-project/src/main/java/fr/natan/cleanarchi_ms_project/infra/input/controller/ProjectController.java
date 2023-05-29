package fr.natan.cleanarchi_ms_project.infra.input.controller;

import fr.natan.cleanarchi_ms_project.domain.entity.Project;
import fr.natan.cleanarchi_ms_project.domain.exceptions_metiers.*;
import fr.natan.cleanarchi_ms_project.domain.ports.input.ProjectInputService;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.entities.EmployeeModel;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.services.CompanyServiceProxy;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.services.EmployeeServiceProxy;
import fr.natan.cleanarchi_ms_project.infra.output.models.ProjectDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {
    private final ProjectInputService projectInputService;
    private final EmployeeServiceProxy employeeServiceProxy;
    private final CompanyServiceProxy companyServiceProxy;

    public ProjectController(ProjectInputService projectInputService,
                             @Qualifier("employee-service-proxy") EmployeeServiceProxy employeeServiceProxy,
                             @Qualifier("company-service-proxy") CompanyServiceProxy companyServiceProxy) {
        this.projectInputService = projectInputService;
        this.employeeServiceProxy = employeeServiceProxy;
        this.companyServiceProxy = companyServiceProxy;
    }

    @GetMapping(value = "/projects", produces = "application/json")
    public List<Project> getAllProjects() {
        List<Project> projects = projectInputService.getAllProjects();
        projects.forEach(project -> {
            project.setCompany(companyServiceProxy.getCompanyByID(project.getCompanyID()));
            project.setEmployee(employeeServiceProxy.getEmployeeByID(project.getEmployeeID()));
        });
        return projects;
    }

    @PostMapping(value = "/projects")
    public Project createProject(@RequestBody ProjectDto projectDto) throws ProjectAlreadyExistsException,
            ProjectFieldsEmptyException, ProjectCreationErrorDueToEmployeeAPIException, ProjectCreationErrorDueToCompanyAPIException, ProjectCreationErrorDueToNotAcceptedEmployeeStateException {
        Project createdProject = projectInputService.createProject(projectDto);
        createdProject.setEmployee(employeeServiceProxy.getEmployeeByID(createdProject.getEmployeeID()));
        createdProject.setCompany(companyServiceProxy.getCompanyByID(createdProject.getCompanyID()));
        return createdProject;
    }

    @PutMapping(value = "/projects/{projectID}")
    public Project updateProject(@PathVariable(name = "projectID") String projectID, @RequestBody ProjectDto projectDto) throws
            ProjectNotFoundException, ProjectCreationErrorDueToEmployeeAPIException, ProjectCreationErrorDueToCompanyAPIException,
            ProjectFieldsEmptyException, ProjectCreationErrorDueToNotAcceptedEmployeeStateException, ProjectAlreadyExistsException {
        Project updatedProject = projectInputService.updateProject(projectID, projectDto);
        updatedProject.setEmployee(employeeServiceProxy.getEmployeeByID(updatedProject.getEmployeeID()));
        updatedProject.setCompany(companyServiceProxy.getCompanyByID(updatedProject.getCompanyID()));
        return updatedProject;
    }

    @DeleteMapping(value = "/projects/{projectID}")
    public void deleteProject(@PathVariable(name = "projectID") String projectID) throws ProjectNotFoundException,
            EmployeeIsAssiacetedToProjectException, CompanyIsAssiacetedToProjectException {
        projectInputService.deleteProject(projectID);
    }

    @GetMapping(value = "/employees/{employeeID}", produces = "application/json")
    public EmployeeModel getEmployee(@PathVariable(name = "employeeID") String employeeID) {
        return employeeServiceProxy.getEmployeeByID(employeeID);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @GetMapping(value = "/projects/{projectID}", produces = "application/json")
    public Optional<Project> getProject(@PathVariable(name = "projectID") String projectID) throws ProjectNotFoundException {
        Optional<Project> project = projectInputService.getProjectByID(projectID);
        project.get().setCompany(companyServiceProxy.getCompanyByID(project.get().getCompanyID()));
        project.get().setEmployee(employeeServiceProxy.getEmployeeByID(project.get().getEmployeeID()));

        return project;
    }

    @GetMapping(value = "/projects/companies/{companyID}", produces = "application/json")
    public List<Project> getProjectAssignedToCompany(@PathVariable(name = "companyID") String companyID) {
        List<Project> projects = projectInputService.getProjectsAssignedToCompany(companyID);
        projects.forEach(project -> {
            project.setCompany(companyServiceProxy.getCompanyByID(project.getCompanyID()));
            project.setEmployee(employeeServiceProxy.getEmployeeByID(project.getEmployeeID()));
        });

        return projects;
    }

    @GetMapping(value = "/projects/employees/{employeeID}", produces = "application/json")
    public List<Project> getProjectAssignedToEmployee(@PathVariable(name = "employeeID") String employeeID) {
        List<Project> projects = projectInputService.getProjectsAssignedToEmployee(employeeID);
        projects.forEach(project -> {
            project.setEmployee(employeeServiceProxy.getEmployeeByID(project.getEmployeeID()));
            project.setCompany(companyServiceProxy.getCompanyByID(project.getCompanyID()));
        });
        return projects;
    }
}
