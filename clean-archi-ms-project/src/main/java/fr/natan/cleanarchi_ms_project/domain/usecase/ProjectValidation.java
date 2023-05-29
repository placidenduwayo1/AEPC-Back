package fr.natan.cleanarchi_ms_project.domain.usecase;

import fr.natan.cleanarchi_ms_project.domain.exceptions_metiers.ExceptionWarnMsg;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.entities.CompanyModel;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.entities.EmployeeModel;
import fr.natan.cleanarchi_ms_project.infra.input.feignclients.entities.EmployeeState;
import fr.natan.cleanarchi_ms_project.infra.output.models.ProjectDto;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class ProjectValidation {
    private ProjectValidation(){}
    public static void projectFormatter(ProjectDto projectDto){
        projectDto.setProjectName(projectDto.getProjectName().strip().toUpperCase());
        projectDto.setEmployeeID(projectDto.getEmployeeID().strip());

    }

    public static boolean areValidProjectFields(ProjectDto projectDto){
        return !projectDto.getProjectName().isBlank()
                && !projectDto.getEmployeeID().isBlank();
    }

    public static boolean isValidEmployeeAPI(EmployeeModel employeeModel){
        return !employeeModel.getEmployeeID().equals(ExceptionWarnMsg.EMPLOYEE_API_ERROR.toString());
    }

    public static boolean isValidCompanyAPI(CompanyModel companyModel){
        return ! companyModel.getCompanyID().equals(ExceptionWarnMsg.COMPANY_API_ERROR.toString());
    }

    public static boolean isInvalidEmployeeState(EmployeeModel employeeModel){
        return employeeModel.getEmployeeState().equals(EmployeeState.HISTORIZED);
    }
}
