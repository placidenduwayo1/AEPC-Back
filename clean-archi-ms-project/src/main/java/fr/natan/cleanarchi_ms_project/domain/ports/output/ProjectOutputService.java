package fr.natan.cleanarchi_ms_project.domain.ports.output;

import fr.natan.cleanarchi_ms_project.domain.entity.Project;
import fr.natan.cleanarchi_ms_project.domain.exceptions_metiers.ProjectCreationErrorDueToCompanyAPIException;
import fr.natan.cleanarchi_ms_project.domain.exceptions_metiers.ProjectCreationErrorDueToEmployeeAPIException;
import fr.natan.cleanarchi_ms_project.domain.exceptions_metiers.ProjectNotFoundException;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.entities.CompanyModel;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.entities.EmployeeModel;
import fr.natan.cleanarchi_ms_project.infra.output.models.ProjectDto;

import java.util.List;
import java.util.Optional;

public interface ProjectOutputService {
    List<Project> getAllProjects();
    List<Project> getProjectByInfo(ProjectDto projectDto);
    Optional<Project> getProjectByID(String projectID) throws ProjectNotFoundException;
    EmployeeModel getEmployeeByID(String employeeID);
    CompanyModel getCompanyByID(String companyID);
    Project createProject(Project project) throws ProjectCreationErrorDueToEmployeeAPIException, ProjectCreationErrorDueToCompanyAPIException;
    void deleteProject(Project project);
    Project updateProject(Project project);
    List<Project> getProjectsAssignedToCompany(String companyID);
    List<Project> getProjectsAssignedToEmployee(String employeeID);
}
