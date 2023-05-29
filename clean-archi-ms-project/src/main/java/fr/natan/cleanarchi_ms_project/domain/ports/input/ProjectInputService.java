package fr.natan.cleanarchi_ms_project.domain.ports.input;

import fr.natan.cleanarchi_ms_project.domain.entity.Project;
import fr.natan.cleanarchi_ms_project.domain.exceptions_metiers.*;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.entities.CompanyModel;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.entities.EmployeeModel;
import fr.natan.cleanarchi_ms_project.infra.output.models.ProjectDto;

import java.util.List;
import java.util.Optional;

public interface ProjectInputService {
    List<Project> getAllProjects();
    List<Project> getProjectByInfo(ProjectDto projectDto);
    Optional<Project> getProjectByID(String projectID) throws ProjectNotFoundException;
    Optional<EmployeeModel> getEmployeeByID(String employeeID);
    Optional<CompanyModel> getCompanyByID(String companyID);
    Project createProject(ProjectDto projectDto) throws ProjectAlreadyExistsException, ProjectFieldsEmptyException,
            ProjectCreationErrorDueToEmployeeAPIException, ProjectCreationErrorDueToCompanyAPIException,
            ProjectCreationErrorDueToNotAcceptedEmployeeStateException;
    void deleteProject(String projectID) throws ProjectNotFoundException, CompanyIsAssiacetedToProjectException, EmployeeIsAssiacetedToProjectException;
    Project updateProject(String projectID, ProjectDto projectDto) throws ProjectNotFoundException,
            ProjectCreationErrorDueToEmployeeAPIException, ProjectCreationErrorDueToCompanyAPIException, ProjectFieldsEmptyException,
            ProjectCreationErrorDueToNotAcceptedEmployeeStateException, ProjectAlreadyExistsException;

    List<Project> getProjectsAssignedToCompany(String companyID);
    List<Project> getProjectsAssignedToEmployee(String employeeID);
}
