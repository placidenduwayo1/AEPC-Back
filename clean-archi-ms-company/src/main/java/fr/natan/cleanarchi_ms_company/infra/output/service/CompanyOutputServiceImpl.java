package fr.natan.cleanarchi_ms_company.infra.output.service;

import fr.natan.cleanarchi_ms_company.domain.entity.Company;
import fr.natan.cleanarchi_ms_company.domain.exceptions.CompanyNotFoundException;
import fr.natan.cleanarchi_ms_company.domain.ports.output.CompanyOutputService;
import fr.natan.cleanarchi_ms_company.infra.output.mapper.CompanyMapper;
import fr.natan.cleanarchi_ms_company.infra.output.models.CompanyDto;
import fr.natan.cleanarchi_ms_company.infra.output.models.CompanyModel;
import fr.natan.cleanarchi_ms_company.infra.output.repository.CompanyRepository;
import fr.natan.cleanarchi_ms_company.infra.input.feignclient.model.ProjectModel;
import fr.natan.cleanarchi_ms_company.infra.input.feignclient.service.ProjectServiceProxy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyOutputServiceImpl implements CompanyOutputService {
    private final CompanyRepository companyRepository;
    private final ProjectServiceProxy projectServiceProxy;

    public CompanyOutputServiceImpl(CompanyRepository companyRepository, ProjectServiceProxy projectServiceProxy) {
        this.companyRepository = companyRepository;
        this.projectServiceProxy = projectServiceProxy;
    }

    @Override
    public List<Company> getAllCompanies() {
        List<CompanyModel> companyModels = companyRepository.findByOrderByCompanyIDAsc();
        return companyModels.stream()
                .map(CompanyMapper::mapToClass)
                .toList();
    }

    @Override
    public Optional<Company> getCompanyByID(String companyID) throws CompanyNotFoundException {
        CompanyModel companyModel = companyRepository.findById(companyID).orElseThrow(
                CompanyNotFoundException::new
        );
        return Optional.of(CompanyMapper.mapToClass(companyModel));
    }

    @Override
    public List<Company> getCompanyByInfos(CompanyDto companyDto) {
        List<CompanyModel> companyModels = companyRepository.findByCompanyNameAndCompanyTypeAndAgency(
                companyDto.getCompanyName(), companyDto.getCompanyType(), companyDto.getAgency()
        );
        return companyModels.stream()
                .map(CompanyMapper::mapToClass)
                .toList();
    }

    @Override
    public Company createCompany(Company company)  {
        CompanyModel mappedModel = CompanyMapper.mapToModel(company);
        CompanyModel savedModel = companyRepository.save(mappedModel);
        return CompanyMapper.mapToClass(savedModel);
    }

    @Override
    public Company updateCompany(Company company) {
        CompanyModel mappedCompany = CompanyMapper.mapToModel(company);
        CompanyModel savedCompany= companyRepository.save(mappedCompany);

        return CompanyMapper.mapToClass(savedCompany);
    }

    @Override
    public void deleteCompany(Company company) {
        companyRepository.delete(CompanyMapper.mapToModel(company));
    }

    @Override
    public List<ProjectModel> getProjectsAssignedToCompany(String companyID) {
        return projectServiceProxy.getProjectsAssignedCompany(companyID);
    }
}
