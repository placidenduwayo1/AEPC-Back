package fr.natan.cleanarchi_ms_project.infra.output.repository;

import fr.natan.cleanarchi_ms_project.domain.entity.ProjectState;
import fr.natan.cleanarchi_ms_project.infra.output.models.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectModel, String> {
    List<ProjectModel> findByOrderByCreatedDateDesc();
    List<ProjectModel> findByProjectNameAndDescriptionAndProjectStateAndEmployeeIDAndCompanyID(
            String projectName,
            String description,
            ProjectState projectState,
            String employeeID,
            String companyID);
    List<ProjectModel> findByCompanyID(String companyID);
    List<ProjectModel> findByEmployeeID(String employeeID);
}
