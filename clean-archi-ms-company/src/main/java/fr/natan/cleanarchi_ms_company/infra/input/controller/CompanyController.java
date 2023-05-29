package fr.natan.cleanarchi_ms_company.infra.input.controller;

import fr.natan.cleanarchi_ms_company.domain.entity.Company;
import fr.natan.cleanarchi_ms_company.domain.exceptions.CompanyAlreadyExistsException;
import fr.natan.cleanarchi_ms_company.domain.exceptions.CompanyAssociedProjectsException;
import fr.natan.cleanarchi_ms_company.domain.exceptions.CompanyFieldsEmptyException;
import fr.natan.cleanarchi_ms_company.domain.exceptions.CompanyNotFoundException;
import fr.natan.cleanarchi_ms_company.domain.ports.input.CompanyInputService;
import fr.natan.cleanarchi_ms_company.infra.output.models.CompanyDto;
import fr.natan.cleanarchi_ms_company.infra.input.feignclient.model.ProjectModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {
    private final CompanyInputService companyInputService;

    public CompanyController(CompanyInputService companyInputService) {
        this.companyInputService = companyInputService;
    }

    @GetMapping(value = "/companies", produces = "application/json")
    public List<Company> getAllCompanies()  {
        return companyInputService.getAllCompanies();
    }

    @PostMapping(value = "/companies")
    public Company createCompany(@RequestBody CompanyDto companyDto) throws CompanyAlreadyExistsException, CompanyFieldsEmptyException {
        return companyInputService.createCompany(companyDto);
    }

    @PutMapping(value = "/companies/{companyID}")
    public Company updateCompany(@PathVariable(name = "companyID") String companyID, @RequestBody CompanyDto companyDto)
            throws CompanyNotFoundException, CompanyFieldsEmptyException, CompanyAlreadyExistsException {
        return companyInputService.updateCompany(companyID, companyDto);
    }

    @GetMapping(value = "/companies/{companyID}", produces = "application/json")
    public Optional<Company> getCompanyByID(@PathVariable(name = "companyID") String companyID) throws CompanyNotFoundException {
        return companyInputService.getCompanyByID(companyID);
    }

    @DeleteMapping(value = "/companies/{companyID}")
    public void deleteCompany(@PathVariable(name = "companyID") String companyID) throws CompanyNotFoundException, CompanyAssociedProjectsException {
        companyInputService.deleteCompany(companyID);
    }

    @GetMapping(value = "/projects/companies/{companyID}", produces = "application/json")
    public List<ProjectModel> getProjectsAssignedToCompany(@PathVariable(name = "companyID") String companyID) throws CompanyNotFoundException {
        return companyInputService.getProjectsAssignedToCompany(companyID);
    }
}
