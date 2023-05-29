package fr.natan.cleanarchi_ms_company.domain.ports.output;

import fr.natan.cleanarchi_ms_company.domain.entity.Company;
import fr.natan.cleanarchi_ms_company.domain.exceptions.CompanyNotFoundException;
import fr.natan.cleanarchi_ms_company.infra.input.feignclient.model.ProjectModel;
import fr.natan.cleanarchi_ms_company.infra.output.models.CompanyDto;

import java.util.List;
import java.util.Optional;

public interface CompanyOutputService {
    List<Company> getAllCompanies();
    Optional<Company> getCompanyByID(String companyID) throws CompanyNotFoundException;
    List<Company> getCompanyByInfos(CompanyDto companyDto);
    Company createCompany(Company company);
    Company updateCompany(Company company);
    void deleteCompany(Company company);
    List<ProjectModel> getProjectsAssignedToCompany(String companyID);
}
