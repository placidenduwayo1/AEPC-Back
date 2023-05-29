package fr.natan.cleanarchi_ms_project.infra.output.mapper;

import fr.natan.cleanarchi_ms_project.domain.entity.Project;
import fr.natan.cleanarchi_ms_project.infra.output.models.ProjectDto;
import fr.natan.cleanarchi_ms_project.infra.output.models.ProjectModel;
import org.springframework.beans.BeanUtils;

public class ProjectMapper {
    private ProjectMapper(){}
    public static Project mapToClass(ProjectModel projectModel) {
        Project project = new Project();
        BeanUtils.copyProperties(projectModel, project);
        return project;
    }

    public static ProjectModel mapToModel(Project project) {
        ProjectModel projectModel = new ProjectModel();
        BeanUtils.copyProperties(project, projectModel);
        return projectModel;
    }

    public static Project dtoToClass(ProjectDto projectDto) {
        Project project = new Project();
        BeanUtils.copyProperties(projectDto, project);
        return project;
    }
}
